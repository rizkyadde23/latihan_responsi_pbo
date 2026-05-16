# Latihan Responsi  
# Praktikum Pemrograman Berbasis Objek
## Rizky Adde Rachmad / 123240150
## IF-E
<hr>  

## Daftar Perubahan  
## 1. Penambahan Koneksi Database  
<pre>src/main/java/com/pbo/latres/config/DatabaseConnection.java</pre>  
### Dilakukan penggunaan database agar data kegiatan yang kita lakukan    
### dapat disimpan permanen ke dalam database yang sebelumnya hanya disimpan sementara.  
### Operasi penggunaan koneksi database ini menggunakan library/dependency  
<pre>mysql-connector-j-9.5.0.jar</pre>  
<hr>  

## 2. Penambahan Model RealTodoRepository  
<pre>src/main/java/com/pbo/latres/model/RealTodoRepository.java</pre>  
### Dilakukan penambahan model agar penggunaan database dapat diimplementasikan  
### melalui metode-metode yang ada di dalam model tersebut.  
### Sehingga model yang baru dapat melakukan query ke database mysql  
<hr>  

## 3. Perubahan pada fungsi Main  
<pre>src/main/java/com/pbo/latres/Latres.java</pre>  
### Dilakukan perubahan instansiasi pada penggunaan repository yang sebelumnya menggunakan  
<pre>FakeTodoRepository.java</pre>  
### dan sekarang menggunakan  
<pre>RealTodoRepository.java</pre>  
### yang sebelumnya telah dibuat  
