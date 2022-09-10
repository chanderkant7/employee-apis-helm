# Sample App for Helm Charts

This is sample springboot app have inbuilt H2 database and sample employee data, with REST API's exposed. 

---

### Prerequisite

Go to Docker Desktop Settings -> General -> Enable Expose daemon on tcp://localhost:2375 without TLS option

Go to Docker Desktop Settings -> Kubernetes -> Select Enable Kubernetes option and click on Apply & Restart button.

Install <b>kubectl</b> and <b>Helm 3.x</b>

---

### 1 - Git Clone Repo, Maven & Docker Build
Use Git clone command to clone the git repo and mvn command to build sample app.

Before the 2nd maven build, update "EmployeeController.java" file... 
```sh 
@RequestMapping("/v2/employee") 
```

```sh
git clone https://github.com/chanderkant7/employee-apis-helm.git
cd employee-apis-helm
mvn clean install
docker build -t employee-apis:v1 .

mvn clean install
docker build -t employee-apis:v2 .
```

### 2 - Create Helm Chart and install

#### Please update values.yaml to match your sample app configuration


```sh
# skip this command as it's already created in the git repo
# it'll create helm chart folder structure for you
helm create emp-helm-charts

# Helm install
# dry run
helm template emp-helm-charts # you'll see the actual yaml files
helm install helm-release emp-helm-charts
helm list
helm history helm-release
kubectl get pod
kubectl --namespace default port-forward $POD_NAME 8080:8080
http://localhost:8080/v1/employee

# with Helm Upgrade to revision 2 
# update values.yaml to change the docker image tag to v2
# tag: "v2"

helm upgrade helm-release emp-helm-charts
helm list
helm history helm-release
kubectl get pod
kubectl --namespace default port-forward $POD_NAME 8080:8080
http://localhost:8080/v2/employee

# with Helm Rollback to revision 1
helm rollback helm-release 1
helm list
helm history helm-release
kubectl get pod
kubectl --namespace default port-forward $POD_NAME 8080:8080
http://localhost:8080/v1/employee

# finally unistall the deployment
helm uninstall helm-release

```

### 3 - Helm Repo

```sh
helm repo list
helm repo add $name $uri
helm repo add jenkins https://charts.jenkins.io
helm repo update
# supply your values.yaml as argument to customize it
helm install jenkins jenkins/jenkins # -f values.yaml
# search repo
helm search repo jenkins
# package your local chart and create tar file, later you can push it to Git Repo or Artifactory
helm package emp-helm-charts
```

### Happy Helming!