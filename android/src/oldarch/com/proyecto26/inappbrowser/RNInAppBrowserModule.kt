package com.proyecto26.inappbrowser

import com.facebook.react.bridge.LifecycleEventListener
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.module.annotations.ReactModule

@ReactModule(name = RNInAppBrowserModuleImpl.NAME)
class RNInAppBrowserModule(reactContext: ReactApplicationContext) :
    ReactContextBaseJavaModule(reactContext),
    LifecycleEventListener {

    init {
        reactApplicationContext.addLifecycleEventListener(this)
    }

    override fun invalidate() {
        reactApplicationContext.removeLifecycleEventListener(this)
    }

    override fun getName(): String {
        return RNInAppBrowserModuleImpl.NAME
    }

    override fun onHostResume() {
        reactApplicationContext.currentActivity?.let { activity ->
            RNInAppBrowserModuleImpl.onStart(activity)
        }
    }

    override fun onHostPause() {}

    override fun onHostDestroy() {}

    @ReactMethod
    fun open(options: ReadableMap, promise: Promise) {
        RNInAppBrowserModuleImpl.open(reactApplicationContext, options, promise)
    }

    @ReactMethod
    fun close() {
        RNInAppBrowserModuleImpl.close()
    }

    @ReactMethod
    fun isAvailable(promise: Promise) {
        RNInAppBrowserModuleImpl.isAvailable(reactApplicationContext, promise)
    }

    @ReactMethod
    fun warmup(promise: Promise) {
        RNInAppBrowserModuleImpl.warmup(promise)
    }

    @ReactMethod
    fun mayLaunchUrl(mostLikelyUrl: String, otherUrls: ReadableArray) {
        RNInAppBrowserModuleImpl.mayLaunchUrl(mostLikelyUrl, otherUrls)
    }

    @ReactMethod
    fun addListener(eventName: String) {
        // iOS only
    }

    @ReactMethod
    fun removeListeners(count: Double) {
        // iOS only
    }
} 