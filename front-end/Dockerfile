FROM node:18.13-alpine3.16 as angular

WORKDIR /app

COPY ../front-end .

RUN ls -al

RUN npm install

RUN npm run build

FROM httpd:alpine3.15

WORKDIR /usr/local/apache2/htdocs

COPY --from=angular /app .
