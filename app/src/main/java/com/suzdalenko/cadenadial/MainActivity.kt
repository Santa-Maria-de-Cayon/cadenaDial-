package com.suzdalenko.cadenadial

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RelativeLayout
import android.widget.ScrollView
import android.widget.TextView
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , View.OnClickListener {

    lateinit var  player: SimpleExoPlayer
    lateinit var mAdViewEs : AdView
    lateinit var es_scrol : ScrollView
    lateinit var layoutParams : RelativeLayout.LayoutParams
    var heigthPlayer = 0
    var heitLinAds = 0
    lateinit var mainActivity : MainActivity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val A:MainActivity = this

        es_scrol = findViewById(R.id.es_scrol)
        MobileAds.initialize(this) {}

       mAdViewEs = findViewById(R.id.mAdViewEs)
       val adRequest: AdRequest = AdRequest.Builder().build()
       mAdViewEs.loadAd(adRequest)
       Log.d("tag", "start start")
       layoutParams = es_scrol.getLayoutParams() as RelativeLayout.LayoutParams
       mAdViewEs.adListener = object: AdListener() {
           override fun onAdLoaded() {
               es_scrol.post{
                   heigthPlayer = player_view.height + 3
                   heitLinAds = mAdViewEs.height + 3
                   layoutParams.setMargins(0, heigthPlayer, 0, heitLinAds);
                   es_scrol.setLayoutParams(layoutParams)
               }
           }
       }

       mainActivity  = this








        player  = ExoPlayerFactory.newSimpleInstance(this)
        player_view.setPlayer(player)
        player.setPlayWhenReady(true);
        player_view.setControllerHideOnTouch(false)


        dial.setOnClickListener(this)
        los40.setOnClickListener(this)
        los40clas.setOnClickListener(this)
        cien.setOnClickListener(this)
        rock.setOnClickListener(this)
        loca.setOnClickListener(this)
        rac1.setOnClickListener(this)
        onda.setOnClickListener(this)
        ibiza.setOnClickListener(this)
        rne.setOnClickListener(this)
        inter.setOnClickListener(this)
        ser.setOnClickListener(this)
        ib.setOnClickListener(this)
        vinilo.setOnClickListener(this)
        cope.setOnClickListener(this)
        max.setOnClickListener(this)
        hit.setOnClickListener(this)
        kiss.setOnClickListener(this)
        gay.setOnClickListener(this)
        fresca.setOnClickListener(this)
        holi.setOnClickListener(this)
        radiole.setOnClickListener(this)
        localatino.setOnClickListener(this)

        _dial.setOnClickListener(this)
        _los40.setOnClickListener(this)
        _los40clas.setOnClickListener(this)
        _cien.setOnClickListener(this)
        _rock.setOnClickListener(this)
        _loca.setOnClickListener(this)
        _rac1.setOnClickListener(this)
        _onda.setOnClickListener(this)
        _ibiza.setOnClickListener(this)
        _rne.setOnClickListener(this)
        _inter.setOnClickListener(this)
        _ser.setOnClickListener(this)
        _ib.setOnClickListener(this)
        _vinilo.setOnClickListener(this)
        _cope.setOnClickListener(this)
        _max.setOnClickListener(this)
        _hit.setOnClickListener(this)
        _kiss.setOnClickListener(this)
        _gay.setOnClickListener(this)
        _fresca.setOnClickListener(this)
        _holi.setOnClickListener(this)
        _radiole.setOnClickListener(this)
        _localatino.setOnClickListener(this)





    }

    private fun playExoPlayer(s: String) {
        val contentMediaSource: ProgressiveMediaSource = ProgressiveMediaSource.Factory(
            DefaultDataSourceFactory(this, "Mozilla")
        ).createMediaSource(Uri.parse(s))
        player.prepare(contentMediaSource)
    }


    private fun openBrouser(s: String) {
        val uris: Uri = Uri.parse(s);val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents);
    }


    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }

    override  fun onCreateOptionsMenu(menu : Menu): Boolean  {
        val visit: String = getString(R.string.visit)
        val com: String = getString(R.string.com)
        val compart : String = getString(R.string.compart)
        val addRadio : String = getString(R.string.addRad)
        menu.add(visit)
        menu.add(com)
        menu.add(compart)
        menu.add(addRadio)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected( item : MenuItem) : Boolean{
        val title: String = item.getTitle().toString()
        if(title == "Comparte" || title == "Поделиться"){
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type="text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "La Radio que te encantara.                 https://play.google.com/store/apps/details?id=com.suzdalenko.cadenadial");
            startActivity(Intent.createChooser(shareIntent, "Radio"))
        }
        else if(title == "Visitame" || title == "Сайт")
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://www.suzdalenko.com")))
        else if(title == "Añade una emisora de radio"){
            val uri = Uri.parse("https://api.whatsapp.com/send?phone=34657666135&text=Hola, quiero añadir una emisora de radio!")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        else startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.suzdalenko.cadenadial")))
        return super.onOptionsItemSelected(item)
    }

    fun setColor(){
        _dial .setTextColor(Color.parseColor("#000000"))
        _los40 .setTextColor(Color.parseColor("#000000"))
        _los40clas .setTextColor(Color.parseColor("#000000"))
        _cien .setTextColor(Color.parseColor("#000000"))
        _rock .setTextColor(Color.parseColor("#000000"))
        _loca .setTextColor(Color.parseColor("#000000"))
        _rac1 .setTextColor(Color.parseColor("#000000"))
        _onda .setTextColor(Color.parseColor("#000000"))
        _ibiza .setTextColor(Color.parseColor("#000000"))
        _rne .setTextColor(Color.parseColor("#000000"))
        _inter .setTextColor(Color.parseColor("#000000"))
        _ser .setTextColor(Color.parseColor("#000000"))
        _ib .setTextColor(Color.parseColor("#000000"))
        _vinilo .setTextColor(Color.parseColor("#000000"))
        _cope .setTextColor(Color.parseColor("#000000"))
        _max .setTextColor(Color.parseColor("#000000"))
        _hit .setTextColor(Color.parseColor("#000000"))
        _kiss .setTextColor(Color.parseColor("#000000"))
        _gay .setTextColor(Color.parseColor("#000000"))
        _fresca .setTextColor(Color.parseColor("#000000"))
        _holi .setTextColor(Color.parseColor("#000000"))
        _radiole .setTextColor(Color.parseColor("#000000"))
        _localatino .setTextColor(Color.parseColor("#000000"))
    }

    override fun onClick(v: View?) {
        if (v != null) {
            if(v is TextView){
                setColor()
                v.setTextColor(Color.parseColor("#ffffff"))
            }

            when(v.id){
                R.id.dial ->      openBrouser("http://suzdalenko.com/radio-es?+cadena-dial")
                R.id.los40 ->     openBrouser("http://suzdalenko.com/radio-es?+los-40")
                R.id.los40clas -> openBrouser("http://suzdalenko.com/radio-es?+los-40-classic")
                R.id.cien ->      openBrouser("http://suzdalenko.com/radio-es?+cadena-100")
                R.id.rock ->      openBrouser("http://suzdalenko.com/radio-es?+rock")
                R.id.loca ->      openBrouser("http://suzdalenko.com/radio-es?+loca-fm")
                R.id.rac1 ->      openBrouser("http://suzdalenko.com/radio-es?+rac1")
                R.id.onda ->      openBrouser("http://suzdalenko.com/radio-es?+onda-cero")
                R.id.ibiza ->     openBrouser("http://suzdalenko.com/radio-es?+ibiza")
                R.id.rne ->       openBrouser("http://suzdalenko.com/radio-es?+rne")
                R.id.inter ->     openBrouser("http://suzdalenko.com/radio-es?+inter-economia")
                R.id.ser ->       openBrouser("http://suzdalenko.com/radio-es?+ser")
                R.id.ib ->        openBrouser("http://suzdalenko.com/radio-es?+ibiza-sonica")
                R.id.vinilo ->    openBrouser("http://suzdalenko.com/radio-es?+vinilo")
                R.id.cope ->      openBrouser("http://suzdalenko.com/radio-es?+cope")
                R.id.max ->       openBrouser("http://suzdalenko.com/radio-es?+maxima")
                R.id.hit ->       openBrouser("http://suzdalenko.com/radio-es?+hit")
                R.id.kiss ->      openBrouser("http://suzdalenko.com/radio-es?+kiss")
                R.id.fresca ->    openBrouser("http://suzdalenko.com/radio-es?+la-fresca")
                R.id.holi ->      openBrouser("http://suzdalenko.com/radio-es?+holidaygym")
                R.id.radiole ->   openBrouser("http://suzdalenko.com/radio-es?+radiole")
                R.id.localatino ->openBrouser("http://suzdalenko.com/radio-es?+loca-latino")

                R.id._dial ->      {mainActivity.title = "Cadena Dial" ;playExoPlayer("https://17873.live.streamtheworld.com/CADENADIAL_SC")}
                R.id._los40 ->     {mainActivity.title = "Los 40" ;playExoPlayer("http://19983.live.streamtheworld.com/LOS40_SC")}
                R.id._los40clas -> {mainActivity.title = "Los 40 Classic" ;playExoPlayer("https://20863.live.streamtheworld.com/LOS40_CLASSIC_SC")}
                R.id._cien ->      {mainActivity.title = "Cadena Cien" ;playExoPlayer("https://cadena100-cope-rrcast.flumotion.com/cope/cadena100-low.mp3")}
                R.id._rock ->      {mainActivity.title = "Rock Fm" ;playExoPlayer("https://rockfm-cope-rrcast.flumotion.com/cope/rockfm-low.mp3")}
                R.id._loca ->      {mainActivity.title = "Loca Fm" ;playExoPlayer("http://audio-online.net:2300/live")}
                R.id._rac1 ->      {mainActivity.title = "Rac 1" ;playExoPlayer("https://streaming.rac1.cat/")}
                R.id._onda ->      {mainActivity.title = "Ondacero" ;playExoPlayer("https://icecast-streaming.nice264.com/ondacero")}
                R.id._ibiza ->     {mainActivity.title = "Ibiza Radio" ;playExoPlayer("http://ibizaglobalradio.streaming-pro.com:8024/stream/1/")}
                R.id._rne ->       {mainActivity.title = "RNE" ;playExoPlayer("http://rne.rtveradio.cires21.com/rne.mp3")}
                R.id._inter ->     {mainActivity.title = "Intereconomia" ;playExoPlayer("http://212.85.46.144/siliconorg")}
                R.id._ser ->       {mainActivity.title = "SER" ;playExoPlayer("https://19983.live.streamtheworld.com/CADENASER_SC")}
                R.id._ib ->        {mainActivity.title = "Ibiza Sonica" ;playExoPlayer("http://s1.sonicabroadcast.com:7005/stream/1/")}
                R.id._vinilo ->    {mainActivity.title = "Radio Vinilo" ;playExoPlayer("http://server9.emitironline.com:10923/;")}
                R.id._cope ->      {mainActivity.title = "Cope" ;playExoPlayer("https://net1-cope-rrcast.flumotion.com/cope/net1-low.mp3")}
                R.id._max ->       {mainActivity.title = "Maxima" ;playExoPlayer("https://20073.live.streamtheworld.com/MAXIMAFM_SC")}
                R.id._hit ->       {mainActivity.title = "Hit" ;playExoPlayer("https://hitfm.kissfmradio.cires21.com/hitfm.mp3")}
                R.id._kiss ->      {mainActivity.title = "Kiss" ;playExoPlayer("http://kissfm.kissfmradio.cires21.com/kissfm.mp3")}
                R.id._gay ->       {mainActivity.title = "Gay" ;playExoPlayer("http://icepool.silvacast.com/GAYFM.mp3")}
                R.id._fresca ->    {mainActivity.title = "Fresca" ;playExoPlayer("http://stream.produccionesdale.com:8899/altacalidad")}
                R.id._holi ->      {mainActivity.title = "Holiday Gym" ;playExoPlayer("http://holidaygym.emitironline.com/")}
                R.id._radiole ->   {mainActivity.title = "Radiole" ;playExoPlayer("http://20723.live.streamtheworld.com/RADIOLE.mp3")}
                R.id._localatino ->{mainActivity.title = "Loca Latino" ;playExoPlayer("http://audio-online.net:8012/live")}

            }
        }
    }
}
