package com.wang.kotlin

import android.content.ContentResolver
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        requestPermission("android.permission.WRITE_EXTERNAL_STORAGE")
    }


    private fun setImageBitmap(imageView: Int, header: Int, size: Int) {
        val image = findViewById<ImageView>(imageView)
        val uri = Uri.parse(
            ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + resources.getResourcePackageName(
                header
            ) + "/"
                    + resources.getResourceTypeName(header) + "/" + resources.getResourceEntryName(
                header
            )
        )
        val headerBitmap = BitmapUtil.getThumbnail(
            uri,
            (size * baseContext.resources.displayMetrics.density + 0.5f).toInt(), baseContext
        )
        image.setImageBitmap(headerBitmap)
    }

    private fun requestPermission(permission: String) {
        if (ContextCompat.checkSelfPermission(
                this,
                permission
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(permission),
                1
            )
        } else {
            setImageBitmap(R.id.backdrop, R.drawable.index_game, 256)
            setImageBitmap(R.id.iv_header, R.drawable.header, 80)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            0 -> {
                setImageBitmap(R.id.backdrop, R.drawable.index_game, 256)
                setImageBitmap(R.id.iv_header, R.drawable.header, 80)
            }
            else -> {
            }
        }
    }

}
