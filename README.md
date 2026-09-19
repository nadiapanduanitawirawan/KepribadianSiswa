# Kepribadian Siswa: Kenali Dirimu

Sistem pakar berbasis desktop untuk mengidentifikasi tipe kepribadian siswa (Introvert atau Ekstrovert) menggunakan metode **Forward Chaining**. Aplikasi ini dikembangkan sebagai proyek tugas akhir (Teknik Informatika, Universitas Indraprasta PGRI) dan diuji pada 50+ responden siswa SMK Taruna Bhakti, Depok.

## Latar Belakang

Mengenali tipe kepribadian membantu siswa memahami cara belajar dan berinteraksi yang paling sesuai dengan dirinya. Proyek ini mengubah proses identifikasi yang biasanya dilakukan secara manual menjadi sistem yang otomatis: siswa mengisi kuesioner, lalu sistem menarik kesimpulan berdasarkan aturan (*rule*) yang telah dirumuskan dari hasil penelitian.

## Fitur Utama

- Kuesioner kepribadian yang diisi langsung oleh siswa.
- Pengolahan jawaban dan penilaian otomatis menggunakan metode Forward Chaining.
- Penyajian hasil identifikasi kepribadian yang mudah dipahami.
- Aturan klasifikasi (*rule base*) yang dirumuskan dari analisis pola jawaban 50+ responden.

## Alur Kerja Sistem

1. Siswa mengisi kuesioner.
2. Jawaban dikumpulkan sebagai fakta (*fact*) awal.
3. Mesin inferensi Forward Chaining mencocokkan fakta dengan aturan yang tersedia, lalu menurunkan fakta baru secara bertahap.
4. Sistem menetapkan tipe kepribadian dan menampilkan hasilnya.

## Teknologi

| Komponen | Teknologi |
|---|---|
| Bahasa pemrograman | Java |
| IDE | Apache NetBeans |
| Metode | Forward Chaining |
| Jenis aplikasi | Desktop (Java Swing) |

## Tampilan Aplikasi

> Tambahkan screenshot di sini setelah diunggah ke folder `screenshots`.

| Halaman Kuesioner | Halaman Hasil |
|---|---|
| ![Kuesioner](screenshots/kuesioner.png) | ![Hasil](screenshots/hasil.png) |

## Cara Menjalankan

1. Pastikan **JDK** dan **Apache NetBeans** sudah terpasang.
2. Unduh proyek ini: klik **Code > Download ZIP**, lalu ekstrak. Atau gunakan perintah:
   ```
   git clone https://github.com/nadiapanduanitawirawan/KepribadianSiswa.git
   ```
3. Buka NetBeans, pilih **File > Open Project**, lalu pilih folder proyek hasil ekstrak.
4. Klik kanan proyek, pilih **Clean and Build**.
5. Jalankan dengan klik kanan proyek, lalu **Run**.

## Struktur Proyek

```
KepribadianSiswa/
├── src/            # Kode sumber Java dan gambar (src/img)
├── nbproject/      # Konfigurasi proyek NetBeans
├── build.xml       # Skrip build Ant
└── manifest.mf     # Manifest aplikasi
```

## Hasil Penelitian

Penelitian studi kasus dilakukan di SMK Taruna Bhakti, Depok, dengan menyebarkan kuesioner kepada 50+ siswa. Pola jawaban dianalisis untuk merumuskan aturan klasifikasi yang digunakan pada sistem.

## Pengembang

**Nadia Panduanita Ramadani**
S1 Teknik Informatika, Universitas Indraprasta PGRI, Jakarta
Email: nadiapanduanita92@gmail.com

## Lisensi

Proyek ini menggunakan lisensi [MIT](LICENSE).
