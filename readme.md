<h1>Aplikasi Facevoting</h1>
Ini adalah Aplikasi validasi dengan deteksi wajah untuk verifikasi voting di kampus:</br><br>
<img src="https://i.postimg.cc/141gs1n7/splashactivity.png" alt="facevoting" />
<img src="https://i.postimg.cc/TwhCFFDW/deteksi-wajah.png" alt="facevoting" />
<img src="https://i.postimg.cc/YC3R9MNW/voting.png" alt="facevoting" />
Detail:<br>
<ul>
	<li>Php minimal 5.3.7</li>
	<li>Codeigniter 3.1.11 http://codeigniter.com/download</li>
	<li>Codeigniter-RestServer 3.1 : https://github.com/chriskacerguis/codeigniter-restserver</li>
	<li>Adminlte 3.0.5 :https://adminlte.io/</li>	
	<li>Image Processing Facex : https://facex.io/</li>
</ul>
</br></br>
Cara Instalasi:</br>
1. git clone https://github.com/alexistdev/Facevoting.git</br>
2. Buat database dan import database yang ada di folder Facevotin</br>
3. Diterminal ketik: composer install</br>
4. ubah config.php dan database.php , sesuaikan dengan url dan databasenya.</br>
5. buka postman dan jalankan http://localhost/Facevoting/api/</br>
6. Buka File yang ada di subfolder "android" dengan android studio<br>
7. pada bagian config.java , lakukan pengaturan sesuai dengan localhost atau url web hosting <br>
8. Buat akun di : https://facex.io/ dan dapatkan API KEY nya.<br>
9. Buka Controller/api/Gambar.php dan cek pada method _banding(). <br>Masukkan api pada bagian:<br>
<pre>
$headers[] = 'User_id: 603f05b94e6c5e6c15c171e7';
</pre>
10. ganti url dibawah menjadi base_url() masih di method _banding():<br>
<br>
<pre>$post = array(
			'img_1' => 'http://facevoting.xyz/gambar/user/'.$photoAwal,
			'img_2' => 'http://facevoting.xyz/gambar/user/'.$photoPembanding
		);
		</pre>
