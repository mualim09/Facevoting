package com.berkatfaatulohalawa1711010164.facevoting.model;

import com.google.gson.annotations.SerializedName;

public class SuaraModel {
    @SerializedName("judul_paslon")
    private final String judul_paslon;
    @SerializedName("ketua_paslon")
    private final String ketua_paslon;
    @SerializedName("wakil_paslon")
    private final String wakil_paslon;
    @SerializedName("photo1_paslon")
    private final String photo1_paslon;
    @SerializedName("photo2_paslon")
    private final String photo2_paslon;
    @SerializedName("perolehan")
    private final String perolehan;

    public SuaraModel(String judul_paslon, String ketua_paslon, String wakil_paslon, String photo1_paslon, String photo2_paslon, String perolehan) {
        this.judul_paslon = judul_paslon;
        this.ketua_paslon = ketua_paslon;
        this.wakil_paslon = wakil_paslon;
        this.photo1_paslon = photo1_paslon;
        this.photo2_paslon = photo2_paslon;
        this.perolehan = perolehan;
    }

    public String getJudul_paslon() {
        return judul_paslon;
    }

    public String getKetua_paslon() {
        return ketua_paslon;
    }

    public String getWakil_paslon() {
        return wakil_paslon;
    }

    public String getPhoto1_paslon() {
        return photo1_paslon;
    }

    public String getPhoto2_paslon() {
        return photo2_paslon;
    }

    public String getPerolehan() {
        return perolehan;
    }
}
