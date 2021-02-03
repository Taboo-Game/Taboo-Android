package com.suatkkrer.taboo_android.Activities

import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.icu.util.UniversalTimeScale.toLong
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.suatkkrer.taboo_android.R
import com.suatkkrer.taboo_android.Model.WordModel
import kotlinx.android.synthetic.main.activity_settings.*
import kotlinx.android.synthetic.main.activity_taboo.*
import java.lang.Exception
import java.util.ArrayList

class TabooActivity : AppCompatActivity() {

    var tabooList = ArrayList<WordModel>()
    lateinit var wordMain : TextView
    lateinit var word1 : TextView
    lateinit var word2 : TextView
    lateinit var word3 : TextView
    lateinit var word4 : TextView
    lateinit var word5 : TextView
    var counter : CountDownTimer? = null
    var pas : Int = 3
    var time : Int = 90000
    var aim : Int = 20
    var timeKeeper : Int = 0
    var pauseKeeper : Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taboo)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        wordMain = findViewById(R.id.kelimeMain)
        word1 = findViewById(R.id.kelime1)
        word2 = findViewById(R.id.kelime2)
        word3 = findViewById(R.id.kelime3)
        word4 = findViewById(R.id.kelime4)
        word5 = findViewById(R.id.kelime5)

        try {
            val sqliteDatabase : SQLiteDatabase = this.openOrCreateDatabase("Settings", MODE_PRIVATE, null)

            sqliteDatabase.execSQL("CREATE TABLE IF NOT EXISTS settings (pas INTEGER, time INTEGER, aim INTEGER, draw INTEGER)")

            val cursor : Cursor = sqliteDatabase.rawQuery("SELECT * FROM settings",null)

            var pasData = cursor.getColumnIndex("pas")
            var timeData = cursor.getColumnIndex("time")
            var aimData = cursor.getColumnIndex("aim")
            var drawData = cursor.getColumnIndex("draw")

            while (cursor.moveToNext()){
                time = cursor.getInt(timeData)*1000
                pas = cursor.getInt(pasData)
                aim = cursor.getInt(aimData)
            }

            cursor.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }






        tabooList.add(WordModel("FİİL","İŞ","OLUŞ","HAREKET","EYLEM","SÖZCÜK"))
        tabooList.add(WordModel("UYAK", "ŞİİR", "DİZE", "BENZERLİK", "KAFİYE", "SES"))
        tabooList.add(WordModel("SÖZLÜK","ANLAM","KELİME","SÖZCÜK","AÇIKLAMA","LÜGAT"))
        tabooList.add(WordModel("KUŞBAKIŞI ","HARİTA","TEPE","YUKARI","GÖRMEK","KROKİ"))
        tabooList.add(WordModel("OKKA","AĞIRLIK","ÖLÇÜ","BİRİM","KİLO","TARTI"))
        tabooList.add(WordModel("KÖK","SÖZCÜK","YAPIM","ÇEKİM","EK","KELİME"))
        tabooList.add(WordModel("ŞİİR","ŞAİR","MISRA","DİZE","KITA","DÖRTLÜK"))
        tabooList.add(WordModel("ÖYKÜ","HİKÂYE","KAHRAMAN","YAZAR","YER","KİTAP"))
        tabooList.add(WordModel("MASAL","OLAĞANÜSTÜ","KAHRAMAN","YAZAR","KELOĞLAN","KİTAP"))
        tabooList.add(WordModel("FAY","HAT","DEPREM","KIRILMAK","SARSILMAK","İSTANBUL"))
        tabooList.add(WordModel("KÜÇÜMSEME","NİTELİK","DEĞERSİZ","YARGI","CÜMLE","AZIMSAMA"))
        tabooList.add(WordModel("METRES","KARI KOCA","EVLİ","ALDATMAK","YASAK","İLİŞKİ"))
        tabooList.add(WordModel("FAX","ÇEKMEK","GÖNDERMEK","YAZI","KAĞIT","FOTOKOPİ"))
        tabooList.add(WordModel("GAZİ","SAVAŞ","YARALANMAK","ŞEHİT","İSTİKLAL MADALYASI","ATATÜRK"))
        tabooList.add(WordModel("VEKTÖR","YÖN","FİZİK","SKALER","ÇİZMEK","DOĞRU"))
        tabooList.add(WordModel("HASIRALTI ETMEK","SAKLAMAK","GİZLEMEK","KORUMAK","YOK ETMEK","ÖRTBAS"))
        tabooList.add(WordModel("VENEDİK","GONDOL","ÜLKE","SU","İTALYA","YÜZMEK"))
        tabooList.add(WordModel("SELÜLİT","BACAK","KADIN","CİLT","YAĞ","PORTAKAL"))
        tabooList.add(WordModel("NORM","KURAL","YERLEŞMİŞ","İLKE","YASA","DÜZEN"))
        tabooList.add(WordModel("ALT","ÜST","YER","TABAN","DERECE","SINIF"))
        tabooList.add(WordModel("ABONE","YONCA EVCİMİK","SATIN ALMAK","ÜYE","DERGİ","GAZETE"))
        tabooList.add(WordModel("TEZGAH","KURMAK","MASA","MUTFAK","SATICI","BÜFE"))
        tabooList.add(WordModel("TEMAS","FİZİKSEL","DEĞME","DOKUNMA","MÜNASEBET","BULUŞMAK"))
        tabooList.add(WordModel("EFSANE","HAYALİ","YARADILIŞ","ÖYKÜ","ABARTMAK","SÖYLENCE"))
        tabooList.add(WordModel("İMLA","KURAL","YAZIM","DİL BİLGİSİ","HATA","TERİM"))
        tabooList.add(WordModel("SAKAL","KIL","YÜZ","TIRAŞ","KESMEK","TOP"))
        tabooList.add(WordModel("LOSYON","TIRAŞ","KOLONYA","PARFÜM","KOKU","BERBER"))
        tabooList.add(WordModel("BARBAR","KABA","İLKEL","KIRICI","UYGARLAŞMA","AKIN"))
        tabooList.add(WordModel("FABL","MASAL","HAYVAN","HİKAYE","ÖYKÜ","DERS"))
        tabooList.add(WordModel("ABDESTHANE","TUVALET","WC","HELA","YÜZNUMARA","ALMAK"))
        tabooList.add(WordModel("HAKİ","RENK","YEŞİL","KAHVERENGİ","ÇALMAK","KAÇMAK"))
        tabooList.add(WordModel("LATİN AMERİKA","GÜNEY","KITA","BREZİLYA","ÜLKE","ARJANTİN"))
        tabooList.add(WordModel("DEFİNE","HARİTA","PARA","ALTIN","ALİ","BABA"))
        tabooList.add(WordModel("ARAMAK","SAÇ","ARAŞTIRMAK","DERLEMEK","ATEŞLEMEK","AYIKLAMAK"))
        tabooList.add(WordModel("İPUCU","İZ","EMARE","VERMEK","DEDEKTİF","SIR"))
        tabooList.add(WordModel("ALTIN","TAKMAK","DEĞERLİ","KUYUMCU","SARRAF","ÇEYREK"))
        tabooList.add(WordModel("AÇISAL HIZ","FİZİK","VEKTÖREL","HAREKET","DAİRESEL","TARAMAK"))
        tabooList.add(WordModel("SÜZMEK","SU","AYIRMAK","SIVI","MAKARNA","KATI"))
        tabooList.add(WordModel("KABAKULAK","HASTALIK","İLTİHAP","ŞİŞMEK","BEZ","TÜKÜRÜK"))
        tabooList.add(WordModel("KÜF","EKMEK","YEŞİL","MANTAR","BAKTERİ","KURT"))
        tabooList.add(WordModel("ANATOMİ","VÜCUT","SİSTEM","İNCELEMEK","ORGAN","DİŞ"))
        tabooList.add(WordModel("KARL MARX","SOSYALİZM","KOMÜNİZM","FELSEFE","MANİFESTO","KAPİTAL"))
        tabooList.add(WordModel("ALTERNATİF AKIM","DOĞRU","ELEKTRİK","DEĞİŞKEN","NİKOLA TESLA","SİNÜS"))
        tabooList.add(WordModel("FOTOKOPİ","KOPYA","MAKİNE","FAX","TARAMAK","KIRTASİYE"))
        tabooList.add(WordModel("BARKOD","ÜRÜN","FİYAT","İMZA","ÇİZGİ","ALT"))
        tabooList.add(WordModel("ODAK","OPTİK","IŞIK","KAYNAK","TOPLANMAK","MİHRAK"))
        tabooList.add(WordModel("MAKAS","KUMAŞ","KESMEK","KAĞIT","NİŞAN","TERZİ"))
        tabooList.add(WordModel("KANTİN","OKUL ","TOST ","KAFETERYA ","ÖĞRENCİ ","YEMEK"))
        tabooList.add(WordModel("İMA ETMEK","ANLAM ","İZ ","DURUM ","DAVRANIŞ ","ALAMET"))
        tabooList.add(WordModel("MÜHİMMAT","DEPO ","SAVAŞ ","CEPHANE ","ORDU ","SİLAH"))
        tabooList.add(WordModel("HIÇKIRIK","SES ","TUTMAK ","DİYAFRAM ","SU ","NEFES"))
        tabooList.add(WordModel("BUZ DEVRİ","ESKİ ÇAĞ","SOĞUK ","ERİMEK ","KAR ","ÇİZGİ FİLM"))
        tabooList.add(WordModel("SALSA","SOS ","DANS ","LATİN ","İSPANYOL ","PARTİ"))
        tabooList.add(WordModel("BONCUK","KOLYE ","TAKI ","RENKLİ ","KÜÇÜK ","YUVARLAK"))
        tabooList.add(WordModel("TRAVESTİ","ERKEK ","KADIN ","TRANSSEKSÜEL ","KILIK ","GİRMEK"))
        tabooList.add(WordModel("DAKTİLO","YAZMAK ","HARF ","KAĞIT ","TUŞ ","STİLO"))
        tabooList.add(WordModel("TELSİZ","TELEFON ","KONUŞMAK ","POLİS ","İLETİŞİM ","BASMAK"))
        tabooList.add(WordModel("SANDAL","MOTOR ","DENİZ ","KÜREK ","SEFA ","BALIKÇI"))
        tabooList.add(WordModel("HAÇ","HRİSTİYANLIK ","ÇAĞLA ŞİKEL","ARTI İŞARETİ","İSA ","ÇARMIH"))
        tabooList.add(WordModel("ASİT","MAVİ ","KIRMIZI ","TURNUSOL ","BAZ ","MİDE"))
        tabooList.add(WordModel("KUŞ BAKIŞI","YÜKSEK ","GENEL ","HAYVAN ","GÖRMEK ","ALAN"))
        tabooList.add(WordModel("HATIR","GÖNÜL  ","KALP ","HAFIZA ","ZİHİN ","KIRMAK"))
        tabooList.add(WordModel("İMRENMEK","KISKANMAK ","GIPTA ETMEK","ÖZENMEK ","CANI ÇEKMEK","İSTEMEK"))
        tabooList.add(WordModel("DUMUR","KÖRELMEK ","APTALLAŞMAK ","ŞOK OLMAK ","ŞAŞIRMAK ","ŞAŞKINA DÖNMEK"))
        tabooList.add(WordModel("KAHIR","MAHVETME ","PERİŞAN ","EZME ","ÇEKMEK ","ETMEK"))
        tabooList.add(WordModel("KÖŞK","BAHÇE ","EV ","SÜSLÜ ","KASİR ","YAPI"))
        tabooList.add(WordModel("ALYANS","EVLİLİK ","YÜZÜK ","KARIKOCA ","PARMAK ","TAKMAK"))
        tabooList.add(WordModel("İKTİDAR","OTORİTE ","MUHALEFET ","YETKİ ","KUVVET ","PARTİ"))
        tabooList.add(WordModel("ÇIBAN","İRİN ","DERİ ","BİRİKMEK ","VÜCUT ","ÇIKMAK"))
        tabooList.add(WordModel("ARAP","SİYAH ","AFRİKA ","FELLAH ","SABUN ","BACI"))
        tabooList.add(WordModel("KALSİYUM","KEMİK ","SÜT ","PEYNİR ","YOĞURT ","DİŞ"))
        tabooList.add(WordModel("ÇAYIR","OTLAMAK ","İNEK ","YEŞİL ","ÇİMEN ","PİKNİK"))
        tabooList.add(WordModel("BALİNA","DENİZ","MEMELİ ","HAYVAN ","YUNUS","SU "))
        tabooList.add(WordModel("OLUMSUZ","NEGATİF ","ZARARLI ","UYGUN ","YAPICI ","YARARLI"))
        tabooList.add(WordModel("MİSYONER","DİN ","YAYMAK ","HRİSTİYAN ","ADAMAK ","DÜŞÜNCE"))
        tabooList.add(WordModel("SİNCAP","HAYVAN ","KEMİRMEK ","AĞAÇ ","FINDIK ","KOKARCA"))
        tabooList.add(WordModel("RAMAZAN BAYRAMI","ŞEKER ","KUTLAMAK ","KURBAN BAYRAMI ","TATİL ","DİNİ"))
        tabooList.add(WordModel("FARENJİT","HASTALIK ","BOĞAZ ","İLTİHAP ","TOZ ","SPREY"))
        tabooList.add(WordModel("ARSA","YER ","ALAN ","YAPI ","TARLA ","YAPMAK"))
        tabooList.add(WordModel("SAÇ","FÖN ","KUAFÖR BERBER ","KADIN ERKEK ","KESTİRMEK","BOYATMAK"))
        tabooList.add(WordModel("HARE","PARLAK ","ÇİZGİ ","DALGA ","SERT ","KUMAŞ"))
        tabooList.add(WordModel("BİLİNÇ","ŞUUR ","TANIMA ","BİLGİ ","GÖRÜŞ ","TEMEL"))
        tabooList.add(WordModel("KALABALIK","İNSAN ","ÇOK ","TOPLULUK ","KARGAŞA ","AŞIRI"))
        tabooList.add(WordModel("SOĞUK ALGINLIĞI","ÜŞÜTMEK ","HASTALIK ","ATEŞ ","NEZLE ","AKINTI"))
        tabooList.add(WordModel("MUTASYON","DEĞİŞİM ","EVRİM ","FARKLI ","GEÇİRMEK ","GEN"))
        tabooList.add(WordModel("NELSON MANDELA","SİYAHİ  ","AFRİKA  ","TUTUKLU  ","BAŞKAN ","LİDER"))
        tabooList.add(WordModel("UZAK DURMAK","YAKLAŞMAMAK ","İSTEMEMEK ","MESAFE ","KOYMAK ","YAKIN"))
        tabooList.add(WordModel("DENEY","KİMYA ","LABORATUVAR ","FARE ","BİLİM ","TÜP"))
        tabooList.add(WordModel("PÜSKÜL","SAÇAK ","İP ","SÜS ","FES ","MISIR"))
        tabooList.add(WordModel("EMBESİL","ZEKA GERİLİĞİ","APTAL ","AHMAK ","SALAK ","MORON"))
        tabooList.add(WordModel("BEDDUA","KÖTÜLÜK ","TUTMAK ","ALMAK ","ETMEK ","BELA"))
        tabooList.add(WordModel("DÖNME DOLAP","LUNAPARK ","YÜKSEK ","ÇOCUK ","EĞLENCE ","OTURMAK"))
        tabooList.add(WordModel("BABA","ERKEK","MAFYA","AİLE","ÇOCUK","ANNE"))
        tabooList.add(WordModel("GAZETE","BASIN","OKUMAK","MEDYA","İLAN","SAYFA"))
        tabooList.add(WordModel("KARATE","DÖVÜŞ SANATLARI","YUMRUK","TEKME","KİD","KAVGA"))
        tabooList.add(WordModel("CAMİ","İMAM","NAMAZ","MÜSLÜMAN","CEMAAT","İBADET"))
        tabooList.add(WordModel("TERLİK","AYAKKABI","HAFİF","ANNE","GİYMEK","EV"))
        tabooList.add(WordModel("ÖRMEK","ŞİŞ","YÜN","KAZAK","DANTEL","ATKI"))
        tabooList.add(WordModel("KLİMA","KALORİFER","SOĞUK","DUVAR","YAZ","SICAK"))
        tabooList.add(WordModel("ÜNİVERSİTE","OKUL","ÖSS","FAKÜLTE","EĞİTİM","ÖĞRENCİ"))
        tabooList.add(WordModel("KRAVAT","GÖMLEK","TAKIM ELBİSE","MEDENİYET YULARI","BOYUN","YAKA"))
        tabooList.add(WordModel("FASULYE","PİLAV","KURU","GAZ","SIRIK","YEMEK"))
        tabooList.add(WordModel("DEDE KORKUT","EFSANE","ERGENEKON","DESTAN","HİKAYE","ESKİ"))
        tabooList.add(WordModel("TAHAMÜL ETMEK","SABIR","DAYANMAK","ARTIK","SINIR","KATLANMAK"))
        tabooList.add(WordModel("SALDIRGAN","AGRESİF","TEHLİKE","KAVGA","ZARAR","DÜŞMAN"))
        tabooList.add(WordModel("ŞİKAYET","HOŞNUTSUZ","MEMNUNİYET","YAKINMAK","TÜKETİCİ","DERT"))
        tabooList.add(WordModel("MEŞALE","ATEŞ","IŞIK","AYDINLIK","YAKMAK","OLİMPİYAT"))
        tabooList.add(WordModel("UYUZ","BULAŞICI","GICIK ETMEK","KÖPEK","HASTALIK","KAŞINMAK"))
        tabooList.add(WordModel("BEZE","HAMUR","YAĞ","PASTA","PİŞKİNLİK","PAZ"))
        tabooList.add(WordModel("TOSBAĞA","VOSVOS","ARABA","KABUK","KAPLUMBAĞA","ESKİ"))
        tabooList.add(WordModel("BÖCEK","ZEHİR","SİNEK","HAŞERE","HAYVAN","YARATIK"))
        tabooList.add(WordModel("YATAKHANE","YATILI","YURT","KIŞLA","OKUL","YATMAK"))
        tabooList.add(WordModel("UZLAŞMAK","İŞBİRLİĞİ","MUTABAKAT","UYUŞMA","ANLAŞMA","İTTİFAK"))
        tabooList.add(WordModel("MAKİNİST","METRO","SİNEMA","FİLM","TREN","KULLANMAK"))
        tabooList.add(WordModel("AYDINLATMAK","GÖRÜNMEK","IŞIK","BİLGİLENDİRMEK","KARANLIK","GİDERMEK"))
        tabooList.add(WordModel("ÇALMAK","POLİS","HIRSIZ","ARANMAK","İZİN","EV"))
        tabooList.add(WordModel("ÇATLAK","ARALIK","AYRILMAK","DELİ","ARA","YARILMAK"))
        tabooList.add(WordModel("ALİM","BİLGE","AKILLI","ZEKİ","HOCA","BİLGİN"))
        tabooList.add(WordModel("LEKE","İZ","ÇAMAŞIR","RENK","ÇIKARTMAK","KİR"))
        tabooList.add(WordModel("BİLMECE","TEKERLEME","SORMAK","OYUN","BULMACA","GİZLİ"))
        tabooList.add(WordModel("LAPTOP","ELDE","BİLGİSAYAR","ÇANTA","MASAÜSTÜ","KASASIZ"))
        tabooList.add(WordModel("EMEKLEMEK","BEBEK","SÜRÜNMEK","YÜRÜMEZ","DİZ","YER"))
        tabooList.add(WordModel("TUĞLA","BLOK","DUVAR","İNŞAAT","MALZEME","YAPI"))
        tabooList.add(WordModel("SAĞLAM","SAĞLIKLI","SIHHATLİ","BOZULMAZ","DAYANIKLI","YIKILMAZ"))
        tabooList.add(WordModel("BİBERON","BEBEK","SÜT","ANNE","EMZİK","YEMEK"))
        tabooList.add(WordModel("KAZMA","TOPRAK","İŞLEMEK","DÜZELTMEK","ÇAPA","ARAÇ"))
        tabooList.add(WordModel("TEKRAR","BİR DAHA","GENE","YENİDEN","YAPMAK","YİNE"))
        tabooList.add(WordModel("AĞZINDAN KAÇIRMAK","AÇIĞA VURMAK","ORTAYA ÇIKARTMAK","POT KIRMAK","GERÇEK","DOĞRU"))
        tabooList.add(WordModel("MAKİNE","CİHAZ","ÇALIŞMAK","BOZULMAK","MÜHENDİS","ALET"))
        tabooList.add(WordModel("METAL","AMETAL","İLETKEN","MADEN","DEMİR","KİMYA"))
        tabooList.add(WordModel("YABANCI","DİL","LİSAN","AVRUPA","TURİST","FARKLI"))
        tabooList.add(WordModel("GÖÇ","DEĞİŞTİRMEK","KUŞ","GİTMEK","TAŞINMAK","HAYVAN"))
        tabooList.add(WordModel("KÜSMEK ","DARILMAK ","KIZMAK ","KONUŞMAK ","TARTIŞMAK ","KAVGA"))
        tabooList.add(WordModel("AVİZE","LAMBA","KRİSTAL","TAVAN","IŞIK","AYDINLIK"))
        tabooList.add(WordModel("KOORDİNAT","YER","ENLEM","BOYLAM","BELİRTMEK","VERMEK"))
        tabooList.add(WordModel("TERİM","KELİME","ANLAM","FATİH","SANAT","KAVRAM"))
        tabooList.add(WordModel("SOYUT","DUYU","ALGILAMAK","GÖRÜLMEYEN","İSİM","SOMUT"))
        tabooList.add(WordModel("BASKÜL","TARTI","KİLO","AĞIR","ÖLÇÜ","HAFİF"))
        tabooList.add(WordModel("HALÜSİNASYON","HAYAL","GERÇEK","GÖRMEK","İLLÜZYON","SERAP"))
        tabooList.add(WordModel("ADEM ELMASI","ERKEK","GIRTLAK","ÇIKINTI","BOĞAZ","HAVVA"))
        tabooList.add(WordModel("SATRANÇ","ŞAH-MAT","KALE","VEZİR","PİYON","FİL"))
        tabooList.add(WordModel("PARAŞÜT","UÇAK","ATLAMAK","UÇMAK","BALON","HAVA"))
        tabooList.add(WordModel("DOST","GÜVEN","SAMİMİ","DÜRÜST","ARKADAŞ","AHLAKLI"))
        tabooList.add(WordModel("KEDİ","PATİ","FARE","TÜY","KUYRUK","HAYVAN"))
        tabooList.add(WordModel("BONKÖR","ELİ AÇIK","CÖMERT","PARA","GÖNLÜ ZENGİN","HARCAMAK"))
        tabooList.add(WordModel("MESAİ","SAAT","İŞ","FAZLA","AKŞAM","KALMAK"))
        tabooList.add(WordModel("YELPAZE","SICAK","RÜZGAR","YAZ","KADIN","SALLAMAK"))
        tabooList.add(WordModel("İŞTAH","ACIKMAK","KESİLMEK","AÇMAK","LEZZET","YEMEK"))
        tabooList.add(WordModel("HALAY","DÜĞÜN","ÇEKMEK","OYNAMAK","MENDİL","MAHMUT TUNCER"))
        tabooList.add(WordModel("PLAKET","ÖDÜL","TÖREN","BAŞARI","VERMEK","TEŞEKKÜR"))
        tabooList.add(WordModel("STAJ","ÖĞRENCİ","ÇALIŞMAK","ÜNİVERSİTE","TECRÜBE","İŞ"))
        tabooList.add(WordModel("TECRÜBE","İŞ","KAZANMAK","ÇALIŞMAK","DENEYİM","YIL"))
        tabooList.add(WordModel("MACUN","CAM","PENCERE","TUTMAK","DİŞ","MESİR"))
        tabooList.add(WordModel("MIZIKÇI","ÇOCUK","KÜSMEK","DARILMAK","BOZMAK","OYUN"))
        tabooList.add(WordModel("ÇAVDAR","ARPA","TAHIL","BUĞDAY","KEPEK","EKMEK"))
        tabooList.add(WordModel("ESKİMO","KUTUP","BUZUL","KAR","SOĞUK","BALIK"))
        tabooList.add(WordModel("BUKALEMUN","HAYVAN","RENK","KERTENKELE","DEĞİŞMEK","SÜRÜNGEN"))
        tabooList.add(WordModel("CEPHE","SAVAŞ","ORDU","ASKER","SALDIRMAK","BARIŞ"))
        tabooList.add(WordModel("PARAGRAF","SINAV","SORU","ANA DÜŞÜNCE","YARDIMCI DÜŞÜNCE","METİN"))
        tabooList.add(WordModel("ÜÇ NOKTA","NOKTALAMA","SON","TAMAMLANMAMIŞ","İSTENMEYEN","CÜMLE"))
        tabooList.add(WordModel("KORNİŞ ","TAVAN ","PERDE ","ASMAK ","PENCERE ","CAM"))
        tabooList.add(WordModel("NİHALE ","ALTLIK ","TENCERE ","ÇAYDANLIK ","SICAK ","TEZGÂH"))
        tabooList.add(WordModel("DUY ","TAVAN ","LAMBA ","IŞIK ","İŞİTMEK ","ANAHTAR"))
        tabooList.add(WordModel("ARMAĞAN ","HEDİYE ","VERMEK ","ALMAK ","DOĞUM GÜNÜ ","SEVİNDİRMEK"))
        tabooList.add(WordModel("KUMBARA ","PARA ","BİRİKTİRMEK ","YATIRIM ","BANKA ","SAKLAMAK"))
        tabooList.add(WordModel("ANTİKA ","MÜZAYEDE ","ZENGİN ","ESKİ ","TABLO ","TARİHİ"))
        tabooList.add(WordModel("SAĞDIÇ","DAMAT","DÜĞÜN","GELİN","GÜVEY","SIRTINA VURMAK"))
        tabooList.add(WordModel("KABZIMAL","MEYVE","SEBZE","HAL","SATMAK","ARACI"))
        tabooList.add(WordModel("MANGALA","OYUN","OSMANLI","KUYU","TAŞ","HAZİNE"))
        tabooList.add(WordModel("BALMUMU","MUM","ERİMEK","HEYKEL","MÜZE","BAL"))
        tabooList.add(WordModel("FERMUAR","PANTOLON","MONT","GİYSİ","KIYAFET","KOT"))
        tabooList.add(WordModel("KELEBEK","RENKLİ","UÇMAK","TIRTIL","KOZA","HAYVAN"))
        tabooList.add(WordModel("MALA","İNŞAAT","DUVAR","USTA","SIVA","ÇİMENTO"))
        tabooList.add(WordModel("TİYATRO","OYUNCU","SAHNE","PERDE","OYUN","SUFLÖR"))
        tabooList.add(WordModel("BAĞLAMA","TÜRKÜ","MÜZİK","SAZ","TEL","AKORT"))
        tabooList.add(WordModel("DERGİ","GAZETE","MECMUA","MAKALE","YAZI","KAPAK"))
        tabooList.add(WordModel("KAPAN","AV","KURT","HAYVAN","TUZAK","FARE"))
        tabooList.add(WordModel("EMPATİ","KENDİNİ","BAŞKASI","YERİNE","KOYMA","DÜŞÜNME"))
        tabooList.add(WordModel("ANAHTAR","KİLİT","METAL","KASA","KAPI","ÇİLİNGİR"))
        tabooList.add(WordModel("HOŞGÖRÜ","MEVLANA","ANLAYIŞ","EMPATİ","NE OLURSAN","GEL"))
        tabooList.add(WordModel("ULEMA","BİLGİN","OSMANLI","DİN","ALİM","HOCA"))
        tabooList.add(WordModel("HEYBETLİ","YÜCE","DAĞ","BÜYÜK","YÜKSEK","İRİ"))
        tabooList.add(WordModel("ÇIRA","ATEŞ","YAKMAK","ODUN","TAHTA","ÇAY"))
        tabooList.add(WordModel("FİDAN","AĞAÇ","BÜYÜMEK","KÜÇÜK","ORMAN","DİKMEK"))
        tabooList.add(WordModel("PRATİK","KOLAY","ZEKÂ","ÇABUK","HIZLI","ÇÖZÜM"))
        tabooList.add(WordModel("KIVILCIM","ATEŞ","KİBRİT","ÇAKMAK","TAŞ","SÜRTMEK"))
        tabooList.add(WordModel("MİSKİN","TEMBEL","UYUŞUK","YAVAŞ","AĞIR","KEDİ"))
        tabooList.add(WordModel("KÖHNE","ESKİ","TARİHİ","YIKILMAK","BİNA","HARABE"))
        tabooList.add(WordModel("AKROSTİŞ","ŞİİR","MISRA","İSİM","İLK","KITA"))
        tabooList.add(WordModel("YAYIK","AYRAN","SU","YOĞURT","ÇALKALAMAK","SÜT"))
        tabooList.add(WordModel("BAMBU","SAZLIK","MOBİLYA","AĞAÇ","MASA","SANDALYE"))
        tabooList.add(WordModel("YABANİ","VAHŞİ","İLKEL","HAYAT","ORMAN","HAYVAN"))
        tabooList.add(WordModel("GÖÇMEN","MÜLTECİ","VİZE","SOĞUK","KUŞ","SICAK"))
        tabooList.add(WordModel("ÇUVAL","TORBA","DOLDURMAK","YEM","UN","KOYMAK"))
        tabooList.add(WordModel("TALİMAT","EMİR","VERMEK","FATURA","BANKA","OTOMATİK ÖDEME"))
        tabooList.add(WordModel("SİFTAH","İLK","GÜN","SATMAK","MAL","ALIŞVERİŞ"))
        tabooList.add(WordModel("FLAMA","BAYRAK","ÜÇGEN","OKUL","İZCİ","TÖREN"))
        tabooList.add(WordModel("MÜSVEDDE","KARALAMA","NOT ALMAK","YAZMAK","KÂĞIT","TEMİZ"))
        tabooList.add(WordModel("AJANDA","DEFTER","İŞ","YAZMAK","GÜN","TOPLANTI"))
        tabooList.add(WordModel("İHALE","BELEDİYE","GİRMEK","AÇMAK","YOLSUZLUK","KAZANMAK"))
        tabooList.add(WordModel("UYANIK","AKILLI","ZEKİ","AÇIKGÖZ","KURNAZ","SAF"))
        tabooList.add(WordModel("PASAKLI","TEMİZ","TİTİZ","KİRLİ","DÜZENLİ","KARIŞIK"))
        tabooList.add(WordModel("HİLE","ALDATMAK","KANDIRMAK","OYUN","YAPMAK","KUMAR"))
        tabooList.add(WordModel("FİRAR","KAÇAK","HAPİS","ASKER","MAHKÛM","ETMEK"))
        tabooList.add(WordModel("FULAR","EŞARP","BAĞLAMAK","BAŞ","BOYUN","KADIN"))
        tabooList.add(WordModel("KAOS","KARIŞIKLIK","ORTAM","KARGAŞA","DÜZEN","YARATMAK"))
        tabooList.add(WordModel("SIRIK","UZUN","ATLAMAK","BOY","ATLETİZM","FASULYE"))
        tabooList.add(WordModel("ARIZA","BOZUK","TAMİR","ÇALIŞMAK","TELEFON","ELEKTRİK"))
        tabooList.add(WordModel("SUİSTİMAL","İYİ","NİYET","KULLANMAK","FAYDALANMAK","KÖTÜ"))
        tabooList.add(WordModel("SISKA","ZAYIF","İNCE","ÇELİMSİZ","ŞİŞMAN","HASTA"))
        tabooList.add(WordModel("ESİR","MAHKÛM","SAVAŞ","DÜŞMEK","TUTSAK","KAMP"))
        tabooList.add(WordModel("NADİR","ZOR","AZ","BULMAK","SIK","ÇOK"))
        tabooList.add(WordModel("BUĞU","BUHAR","CAM","SU","SICAK","ARABA"))
        tabooList.add(WordModel("PATİKA","KEÇİ YOLU","DAĞ","ORMAN","KESTİRME","YÜRÜMEK"))
        tabooList.add(WordModel("VERESİYE","PEŞİN","BORÇ","SATIN ALMAK","ÖDEMEK","DEFTER"))
        tabooList.add(WordModel("ABLUKA","ETRAF","KUŞATMA","SAVAŞ","ÇEVİRMEK","DÜŞMAN"))
        tabooList.add(WordModel("UCUZLUK","İNDİRİM","PAHALI","YÜZDE","FİYAT","VİTRİN"))
        tabooList.add(WordModel("PERFORMANS","DEĞERLENDİRME","BAŞARI","DERS","ÖDEV","YÜKSEK"))
        tabooList.add(WordModel("PARANOYA","ŞÜPHE","AKIL","RUH","HASTALIK","DELİ"))
        tabooList.add(WordModel("GÜZERGÂH","YOL","ARABA","ROTA","SERVİS","TAKİP ETMEK"))
        tabooList.add(WordModel("FESHETMEK","ANTLAŞMA","SÖZLEŞME","İPTAL","GEÇERSİZ","BOZMAK"))
        tabooList.add(WordModel("ZEYBEK","ATATÜRK","OYUN","EGE","EFE","SARI"))
        tabooList.add(WordModel("YADIRGAMAK","GARİP","TUHAF","KABULLENMEK","ŞAŞIRMAK","DAVRANIŞ"))
        tabooList.add(WordModel("MONOTON","AYNI","SIKICI","SIRADAN","BENZER","RUTİN"))
        tabooList.add(WordModel("DİYAR","MEMLEKET","VATAN","DOLAŞMAK","GEZMEK","ÂŞIK VEYSEL"))
        tabooList.add(WordModel("DOZ","MİKTAR","İLAÇ","DOKTOR","REÇETE","AŞIRI"))
        tabooList.add(WordModel("PORSİYON","YEMEK","TABAK","LOKANTA","YARIM","RESTORAN"))
        tabooList.add(WordModel("KABİN","GİYİNMEK","DUŞ","DENEMEK","MAĞAZA","KIYAFET"))
        tabooList.add(WordModel("SERVET","KAZANMAK","ZENGİNLİK","MAL","MÜLK","PARA"))
        tabooList.add(WordModel("TEDARİK","BULMAK","SAĞLAMAK","MALZEME","ETMEK","HAZIRLIK"))
        tabooList.add(WordModel("TABURE","OTURMAK","SANDALYE","KOLTUK","YEMEKHANE","SIRT"))
        tabooList.add(WordModel("EREZYON","TOPRAK","KAYMA","AĞAÇ","HEYELAN","TEMA"))
        tabooList.add(WordModel("ÇAMAŞIR","KİRLİ","YIKAMAK","MAKİNE","DETERJAN","GİYMEK"))
        tabooList.add(WordModel("NUMUNE","ÖRNEK","VERMEK","TAHLİL","YEMEK","KÜÇÜK"))
        tabooList.add(WordModel("VİRAN","ESKİ","YIKIK","HARAP","EV","KÖHNE"))
        tabooList.add(WordModel("KASVET","SIKINTI","GAM","KARANLIK","AYDINLIK","NEŞELİ"))
        tabooList.add(WordModel("MİÇO","TAYFA","GEMİ","KAPTAN","DENİZ","YARDIMCI"))
        tabooList.add(WordModel("HAMAK","YATMAK","AĞAÇ","SALLANMAK","KURMAK","PİKNİK"))
        tabooList.add(WordModel("GADDAR","ACIMASIZ","SERT","KATI","MERHAMET","İNSAF"))
        tabooList.add(WordModel("ÇADIR","KAMP","UYKU TULUMU","TATİL","KURMAK","DOĞA"))
        tabooList.add(WordModel("NADAS","TARLA","EKMEK","BIRAKMAK","DİNLENDİRMEK","ÇİFTÇİ"))
        tabooList.add(WordModel("HASIR","SEPET","ŞAPKA","PLAJ","DENİZ","SERMEK"))
        tabooList.add(WordModel("KONVOY","ARABA","GİTMEK","DİZİLMEK","ARKA","DÜĞÜN"))
        tabooList.add(WordModel("TAKUNYA","TAHTA","TERLİK","AYAKKABI","GİYMEK","HAMAM"))
        tabooList.add(WordModel("AKSİ","SİNİRLİ","TERS","ZIT","ASABİ","HUYSUZ"))
        tabooList.add(WordModel("VEZNE","BANKA","PARA","ÖDEME","ALMAK","MUHASEBE"))
        tabooList.add(WordModel("OLUK","AKMAK","SU","YAĞMUR","SAÇAK","BORU"))
        tabooList.add(WordModel("YAMAÇ","UÇURUM","YÜKSEK","DAĞ","DİK","PARAŞÜT"))
        tabooList.add(WordModel("PİL","KALEM","İNCE","KUMANDA","EL FENERİ","FEN"))
        tabooList.add(WordModel("ZİRAAT","TARIM","ÇİFTÇİ","TOPRAK","HAYVAN","BANKA"))
        tabooList.add(WordModel("PROSPEKTÜS","İLAÇ","ECZANE","OKUMAK","İÇİNDEKİLER","KULLANMAK"))

        try {

            val sqLiteDatabase = this.openOrCreateDatabase("Words", Context.MODE_PRIVATE,null)

            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS words(id INTEGER PRIMARY KEY,anakelime TEXT,kelime1 TEXT,kelime2 TEXT,kelime3 TEXT,kelime4 TEXT,kelime5 TEXT)")

            val cursor = sqLiteDatabase.rawQuery("SELECT * FROM words",null)

            var anakelimeSQL = cursor.getColumnIndex("anakelime")
            var kelime1SQL = cursor.getColumnIndex("kelime1")
            var kelime2SQL = cursor.getColumnIndex("kelime2")
            var kelime3SQL = cursor.getColumnIndex("kelime3")
            var kelime4SQL = cursor.getColumnIndex("kelime4")
            var kelime5SQL = cursor.getColumnIndex("kelime5")

            while (cursor.moveToNext()){
                tabooList.add(WordModel(cursor.getString(anakelimeSQL),
                        cursor.getString(kelime1SQL),cursor.getString(kelime2SQL),
                        cursor.getString(kelime3SQL),cursor.getString(kelime4SQL),cursor.getString(kelime5SQL)))
            }
            cursor.close()

        } catch (e : Exception){
            e.printStackTrace()
        }

        var random = (0..(tabooList.size-1)).random()

        wordMain.text = tabooList[random].anaKelime
        word1.text = tabooList[random].kelime1
        word2.text = tabooList[random].kelime2
        word3.text = tabooList[random].kelime3
        word4.text = tabooList[random].kelime4
        word5.text = tabooList[random].kelime5

        Log.e("ERORORORO",tabooList.size.toString())

        count()


    }

    fun count(){

        countDown.text = ""

        counter = object : CountDownTimer(time.toLong(), 1000){
            override fun onTick(p0: Long) {
                countDown.text = "${p0 / 1000}"
            }

            override fun onFinish() {
                this.start()
            }

        }

        (counter as CountDownTimer).start()

    }

    fun countContinue(){

        countDown.text = timeKeeper.toString()


        Log.e("sadfas",timeKeeper.toString())

        counter = object : CountDownTimer((timeKeeper*1000).toLong(), 1000){


            override fun onTick(p0: Long) {
                countDown.text = "${p0 / 1000}"
            }

            override fun onFinish() {
                this.start()
            }

        }

        (counter as CountDownTimer).start()

    }

    fun randomWord(view: View) {


        var random = (0..(tabooList.size-1)).random()
//        val wordModel2 = tabooList.random()
//
//        Log.e("ERORORORO",wordModel2.toString())

        wordMain.text = tabooList[random].anaKelime
        word1.text = tabooList[random].kelime1
        word2.text = tabooList[random].kelime2
        word3.text = tabooList[random].kelime3
        word4.text = tabooList[random].kelime4
        word5.text = tabooList[random].kelime5

//        wordMain.text = wordModel2.anaKelime
//        word1.text = wordModel2.kelime1
//        word2.text = wordModel2.kelime2
//        word3.text = wordModel2.kelime3
//        word4.text = wordModel2.kelime4
//        word5.text = wordModel2.kelime5
    }

    fun pasClick(view: View) {

    }

    fun falseClick(view: View) {

    }

    fun backOnclick(view: View) {

        val intent = Intent(this,TeamActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun pauseOnClick(view: View) {

        if (pauseKeeper == 0) {
            counter!!.cancel()
            timeKeeper = Integer.parseInt(countDown.text.toString())
            pauseKeeper = 1
            pauseTaboo.setImageResource(R.drawable.ic_baseline_play_arrow_24)
            kelimeMain.visibility = View.INVISIBLE
            kelime1.visibility = View.INVISIBLE
            kelime2.visibility = View.INVISIBLE
            kelime3.visibility = View.INVISIBLE
            kelime4.visibility = View.INVISIBLE
            kelime5.visibility = View.INVISIBLE
        } else {
            countContinue()
            pauseKeeper = 0
            pauseTaboo.setImageResource(R.drawable.ic_baseline_pause_24)
            kelimeMain.visibility = View.VISIBLE
            kelime1.visibility = View.VISIBLE
            kelime2.visibility = View.VISIBLE
            kelime3.visibility = View.VISIBLE
            kelime4.visibility = View.VISIBLE
            kelime5.visibility = View.VISIBLE
        }
    }
}