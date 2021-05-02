package com.example.finalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.finalapp.view.fragments.*
import com.example.finalapp.model.modelclass.NewsModel
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{
    private lateinit var  drawer: DrawerLayout
    var dataList = ArrayList<NewsModel>()
    val TAG = MainActivity::class.java.simpleName
    private val KEY = "163d19643270bc5175c96f6475eda9f8"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)
        val navigationView:NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle =  ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        drawer.addDrawerListener(toggle)

        toggle.syncState()

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, GeneralFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_general)
        }
    }

    override fun onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.getItemId()){
            (R.id.nav_general) -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, GeneralFragment()).commit()
            (R.id.nav_business) -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, BusinessFragment()).commit()
            (R.id.nav_health) -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HealthFragment()).commit()
            (R.id.nav_entertainment) -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, EntertainmentFragment()).commit()
            (R.id.nav_science) -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ScienceFragment()).commit()
            (R.id.nav_sports) -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, SportsFragment()).commit()
            (R.id.nav_technology) -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, TechnologyFragment()).commit()
            (R.id.nav_saved) -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, SavedFragment()).commit()
        }

        drawer.closeDrawer(GravityCompat.START)
        return true
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//
//
//        val inflater:MenuInflater = getMenuInflater()
//        inflater.inflate(R.menu.search_menu,menu)
//
//        val searchManager:SearchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
//        val searchView:SearchView = menu?.findItem(R.id.action_search)?.getActionView() as SearchView
//        val searchMenuItem:MenuItem=menu.findItem(R.id.action_search)
//
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()))
//        searchView.setQueryHint("Enter your keyword for Search...")
//        searchView.setOnQueryTextListener(object :OnQueryTextListener{
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                var frag = supportFragmentManager.findFragmentById(R.id.general_fragment) as GeneralFragment
//                if(query?.length!! > 0){
////                    frag.callData(query)
////                    sendData(query)
//                }
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String): Boolean {
//                Log.i(TAG,newText)
//                var frag = supportFragmentManager.findFragmentById(R.id.general_fragment) as GeneralFragment
////                frag.callData(newText)
//                //                    sendData(newText)
//                return false
//            }
//
//        })
//
//        searchMenuItem.icon.setVisible(false,false)
//
//        return true
////        return super.onCreateOptionsMenu(menu)
//
//    }

//    private fun sendData(query:String){
//        val bundle = Bundle()
//        bundle.putString("Query",query)
//        val fragment=Fragment()
//        fragment.arguments=bundle
//    }
}