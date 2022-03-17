FROM node:14-alpine3.15 AS node
COPY . /code
WORKDIR /code
RUN npm ci && \
    npm run build && \
    rm -rf node_modules

FROM nginx:1.21.6-alpine
RUN mkdir /usr/share/nginx/fe
RUN mv /etc/nginx/conf.d/default.conf /etc/nginx/conf.d/default.conf.bak
COPY docker/nginx.conf /etc/nginx/conf.d
COPY --from=node /code/dist /usr/share/nginx/fe
