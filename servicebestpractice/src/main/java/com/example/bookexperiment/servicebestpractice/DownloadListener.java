package com.example.bookexperiment.servicebestpractice;

public interface DownloadListener {
    void onProgress(int progress);
    void onSuccess();
    void onFailed();
    void onPause();
    void onCanceled();
}
