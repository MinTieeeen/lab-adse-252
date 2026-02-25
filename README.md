# 🎓 Student Management System - Lab Series

**Course:** Công nghệ phần mềm nâng cao (Advanced Software Engineering) - CO3065  
**Giáo viên:** ThS. Lê Đình Thuận (thuanle@hcmut.edu.vn)

---

## 👥 Thông Tin Nhóm

| STT | Họ và tên       | MSSV    |
| --- | --------------- | ------- |
| 1   | Huỳnh Minh Tiến | 2313425 |

---

## 📋 Mục Đích Dự Án

Xây dựng hệ thống **Student Management** - một dịch vụ quản lý hồ sơ sinh viên bằng **Java Spring Boot**, phục vụ cho buổi thực hành **Scrum Agile**.

Hệ thống đóng vai trò là lõi xử lý dữ liệu cho ứng dụng quản lý trường học giả định, cung cấp:

- ✅ Quản lý thông tin hồ sơ sinh viên (Tên, Email, Tuổi)
- ✅ REST API cho các ứng dụng Frontend (Web/Mobile)
- ✅ Giao diện Web Server-Side Rendering (SSR) với Thymeleaf
- ✅ Lưu trữ dữ liệu bền vững vào PostgreSQL Database
- ✅ Containerization với Docker & Deployment

---

## 🏗️ Kiến Trúc Hệ Thống

### Entity Chính: Student

```java
- id: Mã số sinh viên (Unique, nhập tay)
- name: Họ tên sinh viên
- email: Địa chỉ liên hệ (Unique)
- age: Tuổi
```

### Layers (Tầng):

1. **Controller Layer** (`StudentController`, `StudentWebController`)
   - REST API endpoints (`/api/students`)
   - Web UI endpoints (`/students`)

2. **Service Layer** (`StudentService`)
   - Business logic & validation
   - CRUD operations

3. **Repository Layer** (`StudentRepository`)
   - Data persistence using Spring Data JPA
   - Custom queries

4. **Entity Layer** (`StudentEntity`)
   - JPA entity mapping to database

---

## 📁 Cấu Trúc Dự Án

```
student-management/
├── src/
│   ├── main/
│   │   ├── java/vn/edu/hcmut/cse/adse/lab/
│   │   │   ├── StudentManagementApplication.java (Main entry point)
│   │   │   ├── controller/
│   │   │   │   ├── StudentController.java (REST API)
│   │   │   │   ├── StudentWebController.java (Web UI)
│   │   │   │   ├── StudentDetailController.java
│   │   │   │   └── StudentFormController.java
│   │   │   ├── entity/
│   │   │   │   └── StudentEntity.java
│   │   │   ├── repository/
│   │   │   │   └── StudentRepository.java
│   │   │   └── service/
│   │   │       └── StudentService.java
│   │   └── resources/
│   │       ├── application.properties (Configuration)
│   │       ├── static/ (CSS, JS, images)
│   │       └── templates/
│   │           ├── students.html (List view)
│   │           ├── student-form.html (Create/Edit form)
│   │           └── student-detail.html (Detail view)
│   └── test/
│       └── java/...
├── pom.xml (Maven dependencies)
├── Dockerfile (Container image)
├── docker-compose.yml (Multi-container setup)
└── README.md (This file)
```

---

## 🛠️ Yêu Cầu Hệ Thống

- **Java Development Kit (JDK):** 17 trở lên
- **Maven:** 3.6.0+
- **PostgreSQL/SQLite:** Tùy cấu hình
- **Docker & Docker Compose:** (Để chạy containerized)
- **Git:** (Để clone & version control)

---

## 🚀 Hướng Dẫn Cài Đặt & Chạy

### 1️⃣ Clone Repository

```bash
git clone <your-repo-url>
cd student-management
```

### 2️⃣ Cài Đặt Dependencies

```bash
mvn clean install
```

### 3️⃣ Cấu Hình Database

#### Cách A: Dùng PostgreSQL (Recommended)

Tạo file `.env` ở thư mục gốc:

```properties
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/student_db
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=123456
SPRING_JPA_HIBERNATE_DDL_AUTO=update
PORT=8081
```

Hoặc cấu hình trực tiếp trong `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/student_db
spring.datasource.username=postgres
spring.datasource.password=123456
spring.jpa.hibernate.ddl-auto=update
```

Tạo database PostgreSQL:

```sql
CREATE DATABASE student_db;
```

#### Cách B: Dùng SQLite (Development)

```properties
spring.datasource.url=jdbc:sqlite:student.db
spring.jpa.database-platform=org.hibernate.community.dialect.SQLiteDialect
```

### 4️⃣ Chạy Ứng Dụng

#### Local (Development)

```bash
./mvnw clean spring-boot:run
```

Hoặc trên Windows:

```bash
mvnw.cmd clean spring-boot:run
```

#### Với Docker Compose (Production-like)

```bash
docker-compose up --build
```

Ứng dụng sẽ chạy tại: `http://localhost:8080`

### 5️⃣ Truy Cập Ứng Dụng

#### Local Development

- **Web Server:** http://localhost:8080/students
- **REST API:** http://localhost:8080/api/students

#### Deployed Application (Production)

- **Web UI:** https://lab-adse-252.onrender.com/students

---

## 📡 REST API Endpoints

### Student API (JSON)

#### Get All Students

```
GET /api/students
Response: 200 OK
```

```json
[
  {
    "id": "SV001",
    "name": "Nguyễn Văn A",
    "email": "a@hcmut.edu.vn",
    "age": 20
  },
  {
    "id": "SV002",
    "name": "Trần Thị B",
    "email": "b@hcmut.edu.vn",
    "age": 21
  }
]
```

#### Get Student by ID

```
GET /api/students/{id}
Response: 202 ACCEPTED
```

#### Example

```bash
curl http://localhost:8080/api/students/SV001
```

---

## 🎨 Web UI Features

### Page: Danh Sách Sinh Viên (`/students`)

- ✅ Hiển thị danh sách toàn bộ sinh viên
- ✅ Chức năng search theo tên (keyword)
- ✅ Xem chi tiết từng sinh viên
- ✅ Nút tạo sinh viên mới
- ✅ Nút xóa / chỉnh sửa

### Page: Form Thêm/Chỉnh Sửa (`/students/form`)

- ✅ Nhập ID (Mã số)
- ✅ Nhập Tên
- ✅ Nhập Email
- ✅ Nhập Tuổi
- ✅ Validation dữ liệu

### Page: Chi Tiết Sinh Viên (`/students/{id}`)

- ✅ Xem đầy đủ thông tin
- ✅ Chỉnh sửa thông tin
- ✅ Xóa sinh viên

---

## 🗄️ Database Schema

### Table: `students`

```sql
CREATE TABLE students (
    id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    age INT NOT NULL
);
```

---

## 🔄 Lộ Trình Thực Hành (Lab Series)

### [Lab 1] Khởi Tạo & Kiến Trúc ✅

**Mục tiêu:** Làm quen kiến trúc hệ thống, khởi tạo project, kết nối Database

**Deliverables:**

- Spring Boot project scaffold
- Maven configuration
- Database connection setup
- Entity definition

**Câu hỏi lý thuyết:**

#### Bài 1️⃣ - Ràng Buộc UNIQUE (UNIQUE Constraints)

**Thực hành:**

```sql
-- Giả sử đã có sinh viên với ID = 'SV001'
INSERT INTO students (id, name, email, age)
VALUES ('SV001', 'Nguyễn Văn B', 'b@hcmut.edu.vn', 21);

-- Cố tình insert lại ID trùng
INSERT INTO students (id, name, email, age)
VALUES ('SV001', 'Trần Thị C', 'c@hcmut.edu.vn', 20);
```

**Kết quả & Quan sát:**

- **Error:** `UNIQUE constraint failed: students.id`
- **Tại sao Database lại chặn:**
  - Cột `id` được định nghĩa là **PRIMARY KEY** (Khóa chính)
  - Khóa chính phải là **unique** (duy nhất) trong toàn bộ table
  - Điều này đảm bảo mỗi sinh viên có một ID duy nhất, không có duplicate
  - Nếu cho phép trùng lặp, sẽ không thể xác định sinh viên nào một cách chính xác

**Ý Nghĩa:**

- **Data Integrity:** Bảo vệ tính toàn vẹn dữ liệu
- **Entity Identity:** Đảm bảo mỗi entity duy nhất và có thể xác định
- **Referential Integrity:** Tối ưu cho việc tham chiếu (foreign key)
- **Database Design:** UNIQUE constraint là quy tắc cơ bản của relational database

**Từ Góc Độ Java/Spring:**

```java
@Entity
@Table(name = "students")
public class StudentEntity {
    @Id  // Đánh dấu là Primary Key (tự động UNIQUE)
    private String Id;
    ...
}

// Cách xử lý exception trong Spring:
public StudentEntity add(StudentEntity student) {
    try {
        return repository.save(student);
    } catch (DataIntegrityViolationException e) {
        throw new ResponseStatusException(
            HttpStatus.CONFLICT,
            "Mã sinh viên '" + student.getId() + "' đã tồn tại!"
        );
    }
}
```

---

#### Bài 2️⃣ - Ràng Buộc NOT NULL (Data Integrity)

**Mục tiêu:** Hiểu tầm quan trọng của NOT NULL constraint để đảm bảo dữ liệu đầy đủ

**Thực hành:**

```sql
-- Cố tình insert sinh viên với name = NULL
INSERT INTO students (id, name, email, age)
VALUES ('SV999', NULL, 'sv999@hcmut.edu.vn', 22);

-- Hoặc bỏ trỏng cột name
INSERT INTO students (id, email, age)
VALUES ('SV999', 'sv999@hcmut.edu.vn', 22);
```

**Kết quả & Quan sát:**

- **Error:** `NOT NULL constraint failed: students.name`
- **Database có báo lỗi không?** ✅ **CÓ** - Database sẽ từ chối insert này
- **Tại sao:**
  - Cột `name` được định nghĩa là **NOT NULL**
  - Database bắt buộc phải có giá trị cho field này
  - Không cho phép NULL (trống rỗng, không xác định)

**Nếu bypass được constraint này (ví dụ: comment NOT NULL):**

```sql
-- Nếu cho phép NULL (BAD DESIGN):
CREATE TABLE students (
    id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(255),  -- Không có NOT NULL = cho phép NULL
    email VARCHAR(255) UNIQUE NOT NULL,
    age INT NOT NULL
);
```

**Ảnh hưởng khi Java đọc dữ liệu lên:**

```java
// StudentEntity
@Entity
@Table(name = "students")
@Data
public class StudentEntity {
    @Id
    private String Id;

    private String name;  // Có thể NULL nếu không có NOT NULL constraint

    @Column(unique = true)
    private String email;
    private int age;
}

// Service lấy dữ liệu
public void processStudents() {
    List<StudentEntity> students = repository.findAll();

    for (StudentEntity sv : students) {
        // LỖI TIỀM ẩN: name có thể NULL
        String greeting = "Xin chào " + sv.getName();  // NullPointerException!

        // Hoặc chuỗi trở thành: "Xin chào null"
        System.out.println(greeting);
    }
}

// Frontend (Thymeleaf)
// <p th:text="${sv.name}"></p>
// Có thể render: <p>null</p>  (không phải lỗi nhưng UX xấu)
```

**Hệ Quả:**

1. ❌ **Code Complexity:** Phải thêm null-check ở khắp nơi

   ```java
   if (sv.getName() != null && !sv.getName().isEmpty()) {
       // Process name
   }
   ```

2. ❌ **Data Quality:** Dữ liệu không đầy đủ, khó bảo trì

   ```
   SV001 | null | a@hcmut.edu.vn | 20  ← Không thể quản lý
   ```

3. ❌ **Business Logic Errors:** Tính toán sai lệch

   ```java
   public String getStudentInfo() {
       return "ID: " + id + ", Name: " + name;  // "Name: null" là hiểu sai
   }
   ```

4. ❌ **Database Query Issues:** Khó tìm kiếm, filter dữ liệu
   ```sql
   -- Khó phân biệt: NULL vs chưa nhập
   SELECT * FROM students WHERE name = '';  -- Không work nếu NULL
   ```

**Giải Pháp Tốt Nhất (Best Practice):**

```java
@Entity
@Table(name = "students")
@Data
public class StudentEntity {
    @Id
    private String Id;

    @NotNull(message = "Tên sinh viên không được để trống")
    @NotBlank(message = "Tên sinh viên không được chỉ chứa khoảng trắng")
    private String name;  // Bắt buộc có giá trị

    @Column(unique = true)
    @Email
    private String email;

    @Min(value = 15, message = "Tuổi tối thiểu là 15")
    @Max(value = 100, message = "Tuổi tối đa là 100")
    private int age;
}

// Service validation
@Transactional
public StudentEntity add(StudentEntity student) {
    // Validation logic
    if (student.getName() == null || student.getName().trim().isEmpty()) {
        throw new IllegalArgumentException("Tên sinh viên không được để trống");
    }
    if (student.getEmail() == null || !student.getEmail().contains("@")) {
        throw new IllegalArgumentException("Email không hợp lệ");
    }

    return repository.save(student);
}
```

**Database Schema (Tốt):**

```sql
CREATE TABLE students (
    id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,           -- Ràng buộc tính bắt buộc
    email VARCHAR(255) UNIQUE NOT NULL,   -- Ràng buộc duy nhất + bắt buộc
    age INT NOT NULL CHECK (age >= 15),   -- Ràng buộc kiểm tra giá trị
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

---

**Kết Luận:**

- ✅ **UNIQUE constraint:** Bảo vệ tính duy nhất của Primary Key, ngăn duplicate
- ✅ **NOT NULL constraint:** Bảo vệ tính toàn vẹn dữ liệu, đảm bảo field bắt buộc
- ✅ **Data Integrity:** Tầm quan trọng: Database > Backend Validation > Frontend Validation
- ✅ **Best Practice:** Luôn define constraints rõ ràng tại database layer

---

### [Lab 2] Xây Dựng Backend REST API ✅

**Mục tiêu:** Code các tầng Repository, Service, Controller để tạo REST API

**Deliverables:**

- `StudentRepository` - Custom queries (`findByNameContainingIgnoreCase`)
- `StudentService` - Business logic (getAll, getById, searchByName, add, deleteById)
- `StudentController` - REST endpoints (@GetMapping, @PostMapping, @PutMapping, @DeleteMapping)

**Endpoints Implemented:**

- `GET /api/students` - Lấy danh sách tất cả
- `GET /api/students/{id}` - Lấy chi tiết theo ID

---

### [Lab 3] Xây Dựng Frontend (SSR) ✅

**Mục tiêu:** Xây dựng giao diện Web Server-Side Rendering (SSR) với Thymeleaf

**Deliverables:**

- `StudentWebController` - Server-side routes (@GetMapping mapping to HTML)
- Thymeleaf templates:
  - `students.html` - Danh sách (GET /students)
  - `student-form.html` - Form thêm/sửa (GET/POST /students/form)
  - `student-detail.html` - Chi tiết (GET /students/{id})

**Features:**

- Hiển thị danh sách sinh viên từ database
- Search functionality (keyword parameter)
- CRUD form
- Responsive design

---

### [Lab 4] Hoàn Thiện Sản Phẩm ✅

**Mục tiêu:** Hoàn chỉnh CRUD WebUI & tích hợp PostgreSQL

**Deliverables:**

- Complete CRUD operations via Web UI:
  - ✅ **CREATE:** Form tạo sinh viên mới (POST /students/form)
  - ✅ **READ:** Danh sách & chi tiết (GET /students, GET /students/{id})
  - ✅ **UPDATE:** Chỉnh sửa thông tin (PUT /students/{id})
  - ✅ **DELETE:** Xóa sinh viên (DELETE /students/{id})
- Form validation (Frontend + Backend)
- Error handling & user feedback
- PostgreSQL integration

---

### [Lab 5] Docker & Deployment 🚀

**Mục tiêu:** Đóng gói ứng dụng với Docker và deploy lên Cloud

**Deliverables:**

- Multi-stage Dockerfile (optimize size)
- docker-compose.yml với PostgreSQL service
- Environment configuration (.env file)
- Publishing to public URL

**Docker Implementation:**

```dockerfile
# Stage 1: Build
FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

**Deployed Application:**

```
Public URL: https://lab-adse-252.onrender.com
Database: PostgreSQL on Neon/Railway/Render
Hosting: Render
Status: ✅ Deployed Successfully
```

**Docker Commands:**

```bash
# Build image
docker build -t student-management:latest .

# Run container
docker run -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/student_db \
  -e SPRING_DATASOURCE_USERNAME=postgres \
  -e SPRING_DATASOURCE_PASSWORD=123456 \
  student-management:latest

# Or use docker-compose
docker-compose up --build
```

**Deployment Checklist:**

- ✅ Dockerfile optimized (multi-stage build to reduce image size)
- ✅ docker-compose.yml configured with PostgreSQL service
- ✅ Environment variables externalized (.env file)
- ✅ Database migration (Hibernate ddl-auto)
- ✅ Logging configured
- ✅ Health checks implemented (/actuator/health)

---

## 📄 Lịch Sử Cập Nhật

| Version | Date         | Changes                        |
| ------- | ------------ | ------------------------------ |
| 1.0     | Feb 25, 2026 | Initial setup                  |
| 1.1     | Feb 25, 2026 | Complete Lab 1-5 documentation |

---

**Last Updated:** February 25, 2026
