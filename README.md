 # 🚀 Spring Boot CI/CD with GitHub Actions & Docker

This project demonstrates a fully automated CI/CD pipeline using **Spring Boot**, **GitHub Actions**, and **Docker**.
The pipeline automatically:

* Builds the Spring Boot application
* Packages it into a Docker image
* Pushes the image to Docker Hub
* Ensures dependencies and workflows run smoothly

---

## 📁 Project Structure

```
git-action-docker/
└── demo-git_action-docker/
    ├── src/
    ├── pom.xml
    ├── target/
    ├── Dockerfile
    └── README.md
```

---

## ⚙️ Technologies Used

* **Java 17 (Temurin)**
* **Spring Boot**
* **Maven**
* **Docker**
* **GitHub Actions**
* **Docker Hub Registry**

---

## 🚧 Build the JAR using git Maven Repository

```bash
on:
  push:
    branches:
      - master
  pull_request:
    branches:
      - master
jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          java-version: '17'
          distribution: temurin
          cache: maven
      - name: Build with Maven
        run: mvn clean install  
        working-directory: demo-git_action-docker
```

This generates:

```
target/springboot_githubaction_demo.jar
```

---

## 🐳 Docker Support

### **Dockerfile**

```dockerfile
FROM eclipse-temurin:17-jdk
WORKDIR /app

COPY demo-git_action-docker/target/springboot_githubaction_demo.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

### **Build Docker Image**

```bash
docker build -t springboot-demo .
```

### **Run Container**

```bash
docker run -p 8080:8080 springboot-demo
```

---

## 🔄 GitHub Actions CI/CD Pipeline

The workflow automatically:

✔ Checks out the code
✔ Installs JDK 17
✔ Runs Maven build
✔ Builds Docker image
✔ Pushes image to Docker Hub

### **Workflow File: `.github/workflows/maven-docker.yml`**

```yaml
name: SpringbootProject CI/CD with Maven
on:
  push:
    branches:
      - master
  pull_request:
    branches:
      - master
jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          java-version: '17'
          distribution: temurin
          cache: maven
      - name: Build with Maven
        run: mvn clean install -B
        working-directory: demo-git_action-docker
        
      - uses: mr-smithers-excellent/docker-build-push@v4
        name: Build & push Docker image
        with:
          image: codebyarunyadav/springboot_githubaction_demo
          tags: 'latest'
          registry: docker.io
          dockerfile: Dockerfile
          username: '${{ secrets.DOCKER_USERNAME }}'
          password: '${{ secrets.DOCKER_PASSWORD }}'
---

## 🔐 Required GitHub Secrets

Set the following secrets in **GitHub → Settings → Secrets → Actions**:

| Secret Name       | Description         |
| ----------------- | ------------------- |
| `DOCKER_USERNAME` | Docker Hub username |
| `DOCKER_PASSWORD` | Docker Hub password |

---

## ▶️ Running the App

After the Docker image is pushed, run it anywhere (Linux, EC2, VM, Kubernetes):

```bash
docker pull codebyarunyadav/springboot_githubaction_demo:master-b8ac0c3

 

---

## 📌 Notes

* Build context must be `demo-git_action-docker/` so Docker can find the `target/` directory.
* JAR must be generated *before* Docker build.
* The pipeline uses **eclipse-temurin:17-jdk**, a stable replacement for deprecated `openjdk` images.

---

## 🤝 Contributing

Pull requests are welcome! For major changes, open an issue first to discuss what you want to change.

---

## 📜  Thank You 📜 ## 
 
 
