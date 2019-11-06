package com.example.cameraxdemo

import android.content.pm.PackageManager
import android.graphics.Matrix
import android.os.Bundle
import android.util.Size
import android.view.Surface
import android.view.TextureView
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraX
import androidx.camera.core.Preview
import androidx.camera.core.PreviewConfig
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity(), LifecycleOwner {
    private val executor = Executors.newSingleThreadExecutor()
    private var viewFinder: TextureView? = null
    private val REQUEST_CODE_PERMISSIONS = 10
    private val REQUIRED_PERMISSIONS = arrayOf(android.Manifest.permission.CAMERA)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //request permission
        if (allPermissionsGranted()) {
            viewFinder?.post { startCamera() }
        } else {
            ActivityCompat.requestPermissions(
                this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS
            )
        }
        //add listener
        val addOnLayoutChangeListener =
            viewFinder?.addOnLayoutChangeListener { view, i, i, i, i, i, i, i, i ->
                updateTransform()
            }
    }

    private fun startCamera() {
        val previewConfig = PreviewConfig.Builder().apply {
            setTargetResolution(Size(640, 480))
        }.build()
        val preview = Preview(previewConfig)
        //
        preview.setOnPreviewOutputUpdateListener {
            val parent = viewFinder?.parent as ViewGroup
            parent.removeView(viewFinder)
            parent.addView(viewFinder, 0)

            viewFinder.surfaceTexture = it.surfaceTexture
            updateTransform()
        }
        CameraX.bindToLifecycle(this, preview)
    }

    private fun updateTransform() {

        val matrix = Matrxix()
        //centerview
        val centerX = viewFinder?.width?.div(2f)
        val centerY = viewFinder?.height?.div(2f)

        val rotationDegree = when (viewFinder.display.rotation) {
            Surface.ROTATION_0 -> 0
            Surface.ROTATION_90 -> 90
            Surface.ROTATION_270 -> 270
            Surface.ROTATION_180 -> 180
            else -> return
        }
        matrix.postRotate(-rotationDegree.toFloat(), centerX, centerY)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (allPermissionsGranted()) {
                viewFinder?.post { startCamera() }
            } else {
                Toast.makeText(
                    this, "Permissions not granted by the user.",
                    Toast.LENGTH_LONG
                ).show()
                finish()
            }
        }
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

}
