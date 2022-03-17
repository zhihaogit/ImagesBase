#!/bin/bash
# docker打包上传
# $1当前版本号
if [ $1 = "" ]
then
    echo "need version tag"
else
    image_name="zhihao2022/images_base_frontend:$1"
    docker build -f docker/Dockerfile -t ${image_name} . && \
    docker push ${image_name}
    echo -e "✅ SUCCESS ✅\nThere is the image name👇\n${image_name}"
fi
