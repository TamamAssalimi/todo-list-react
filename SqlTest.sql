#Mencari Ponsel
SELECT Ponsel.Merek, count(Ponsel.Model) 
	FROM Ponsel
	where Ponsel.DualSim=true
	group by Ponsel.Merek

#Mencari Pahlawan Super
Select p.NamaPahlawan, p.TempatTinggal 
	FROM Senjata s inner Join PahlawanSuper p on s.PahlawanSuperID=p.ID 
		Left Join JenisSenjata js on s.JenisSenjataID = js.id
	where js.JenisSenjata='Kapak'

#Mencari Cinta yang Hilang
Select top 100 pddk.Nama, pddk.TempatTinggal, pddk.TanggalLahir
	FROM Penduduk pddk inner join Pasangan psgn on pdd.ID=psgn.PendudukID
		Right join Perpisahan ppshn on ppshn.PasanganID=psgn.ID
	Order by ppshn.TanggalPisah DESC

