#!/bin/bash
if [ $1 = "" ]
then
    echo -e "❌ need new version tag ❌"
else
    origin_be_image=zhihao2022/images_base_backend:0.0.1
    new_be_image=zhihao2022/images_base_backend:$1
    cd backend
    mvn package dockerfile:build
    docker tag ${origin_be_image} ${new_be_image} && \
    docker push ${new_be_image} && \
    docker rmi ${origin_be_image} ${new_be_image}

    new_fe_image=zhihao2022/images_base_frontend:$1
    cd ../frontend
    docker build -f docker/Dockerfile -t ${new_fe_image} . && \
    docker push ${new_fe_image} && \
    docker rmi ${new_fe_image}
    echo -e "✅ SUCCESS ✅"
fi

