# Reto Intercorp Retail
## Comandos para Despliegue para AZURE

## Cambiar ${containerRegistryServer} Por el container registry deseado (incluido en el yaml)
## Cambiar ${username} y ${password} Por el usuario y contraseña del container registry
## Cambiar ${name} por el nombre del container registry
```sh
mvn clean install -Dmaven.test.skip=true &&
az acr login --name ${name} --username ${username} --password ${password} &&
docker build -t="${containerRegistryServer}/reto:0.0.1" --build-arg artifact_id=reto --build-arg artifact_version=0.0.1 . &&
docker push ${containerRegistryServer}/reto:0.0.1 &&
cd kubernetes &&
kubectl delete -f deployment.yml &&
kubectl create -f deployment.yml
```