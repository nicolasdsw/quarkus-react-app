# quarkus-react-crud project
This project uses Quarkus, the Supersonic Subatomic Java Framework: https://quarkus.io/
This project uses React: https://github.com/facebook/create-react-app

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

Backend: 
  `./mvnw quarkus:dev`

Frontend: 
  `cd frontend`
  `yarn start`

## Packaging and running the application  

The application is packageable using `./mvnw clean package -DskipTests`

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.
Or you can use Docker to build the native executable using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.
You can then execute your binary: `./target/crud-1.0.0-runner`
If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image-guide .