package com.kbeanie.imagechooser.factory;

import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import com.kbeanie.imagechooser.api.FileUtils;

import java.io.File;

/**
 * Created by vervik on 9/27/15.
 */
public class UriFactory {

    static String TAG = UriFactory.class.getSimpleName();

    /**
     * If set, it will be the temp URI where the camera app should save the captured image / video to
     *
     * intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
     */
    private Uri captureUri;


    private UriFactory() {
        // private
    }


    public void setCaptureUri(Uri captureUri) {
        Log.d(TAG, "Capture URI set. Is: " + captureUri);
        this.captureUri = captureUri;
    }

    public Uri getCaptureUri(String filePathOriginal) {
        if(captureUri != null) {
            Log.d(TAG, "Capture URI set. We return: "+captureUri);
            return captureUri;
        }

        return Uri.fromFile(new File(filePathOriginal));
    }

    public void reset() {
        Log.d(TAG, "We reset capture URI");
        this.captureUri = null;
    }


    private static UriFactory instance;

    public static UriFactory getInstance() {
        if(instance == null) {
            instance = new UriFactory();
        }
        return instance;
    }

    /*
    filePathOriginal = FileUtils.getDirectory(foldername)
                    + File.separator + DateFactory.getInstance().getTimeInMillis() //Calendar.getInstance().getTimeInMillis()
                    + ".jpg";
            intent.putExtra(MediaStore.EXTRA_OUTPUT,
                    Uri.fromFile(new File(filePathOriginal)));
     */
}
