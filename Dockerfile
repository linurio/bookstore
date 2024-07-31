FROM gradle:8.9-jdk22-alpine AS build

WORKDIR /app

COPY . .

RUN ./gradlew installDist -p api

FROM gradle:8.9-jdk22-alpine

WORKDIR /app

COPY --from=build /app/api/build/install/api/ /app/

EXPOSE 4200

CMD ["./bin/api"]
