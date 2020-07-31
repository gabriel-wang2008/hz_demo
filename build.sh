JAR_NAME=demo-0.0.1-SNAPSHOT.jar
IMAGE_NAME=JAR_NAME=hub.test.com:5000/demo-0.0.1-SNAPSHOT
VERSION_ID=1.0
# 获取已经存在的镜像
ole_image_id=`docker images|grep ${IMAGE_NAME}|grep ${VERSION_ID}|awk '{print $3}'`
# 删掉存在的镜像
if [[ -n "${ole_image_id}" ]]; then
	docker rmi -f ${ole_image_id}
fi
# 通过项目根目录下的Dokcerfile来构建镜像 -f filename --build-arg <key=value> 给Dockerfile传递参数
# -t 镜像的名称:版本  这里我将jenkins的构建次数当作镜像的版本
docker build --build-arg jar_name=${JAR_NAME} -t ${IMAGE_NAME}:${VERSION_ID} .

# 获取构建好的镜像的id
new_image_id=`docker images|grep ${IMAGE_NAME}|grep ${VERSION_ID}|awk '{print $3}'`

# 根据生成的镜像，tag出一个名称空间不同的镜像（腾讯云能识别的镜像）
sudo docker tag ${new_image_id} ${IMAGE_NAME}:${VERSION_ID}

# 将镜像仓库能够试别的镜像推送到仓库
sudo docker push ${IMAGE_NAME}:${VERSION_ID}