package com.example.githubinfo.users

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.githubinfo.R
import com.example.githubinfo.model.GitHubUser
import com.example.githubinfo.network.APIClient.client
import com.example.githubinfo.network.UserEndPoints
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserDetailedActivity : AppCompatActivity() {

    lateinit var imgAvatar : ImageView
    lateinit var tvemail : TextView
    lateinit var tvusername : TextView
    lateinit var tvfollowing : TextView
    lateinit var tvfollowers : TextView
    lateinit var tvlocation : TextView
    lateinit var tvbio : TextView
    lateinit var tvlogin : TextView

    var bitmap :Bitmap? = null
    var strUsername = ""

    companion object {
        private val TAG = UserDetailedActivity::class.java.simpleName
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detailed)

        imgAvatar = findViewById(R.id.avatar)
        tvusername = findViewById(R.id.username)
        tvbio = findViewById(R.id.biodata)
        tvlocation = findViewById(R.id.location)
        tvemail = findViewById(R.id.email)
        tvfollowers = findViewById(R.id.followers)
        tvfollowing = findViewById(R.id.following)
        tvlogin = findViewById(R.id.login)

        val bundle : Bundle = intent.extras!!
        strUsername = bundle.getString("username").toString()
        Log.i(TAG, strUsername)

        loadData()
    }

    fun loadData() {
        val apiService: UserEndPoints = client!!.create(UserEndPoints::class.java)
        val call: Call<GitHubUser?>? = apiService.getUser(strUsername)
        call!!.enqueue(object : Callback<GitHubUser?> {
            override fun onResponse(call: Call<GitHubUser?>?, response: Response<GitHubUser?>) {
                tvusername.text = "Username: " + response.body()!!.name
                tvemail.text = "Email: " + response.body()!!.email
                tvfollowers.text = "Followers: " + response.body()!!.followers
                tvfollowing.text = "Following: " + response.body()!!.following
                tvlogin.text = "LogIn: " + response.body()!!.login
                tvlocation.text = "Login: " + response.body()!!.location
                tvbio.text = "Bio: " + response.body()!!.bio
                Picasso.with(applicationContext).load(response.body()!!.avatar).into(imgAvatar)

                /*val imageDownloader = ImageDownloader()
                try {
                    bitmap = imageDownloader.execute(response.body()!!.avatar).get()
                    imgAvatar.setImageBitmap(bitmap)
                    imgAvatar.layoutParams.height = 220
                    imgAvatar.layoutParams.width = 220
                } catch (e: Exception) {
                    e.printStackTrace()
                }*/
                Log.i(
                    TAG,
                    response.body()!!.name + response.body()!!.email + response.body()!!
                        .followers + response.body()!!.following + response.body()!!.login
                )
            }

            override fun onFailure(call: Call<GitHubUser?>, t: Throwable) {}
        })
    }
}