package com.ising99.wkis.domain;

import java.sql.Timestamp;

/**
 * Created by Raise on 2015/1/19.
 */
public class TmsMixer {
    private int id;
    private int userid;
    private int main_volume;    //	总音量
    private int music_volume;    //	伴奏
    private int microphone_volume;//	麦克风音量
    private int microphone_echo_volume;    //	回音
    private int melody_volume;    //	导唱
    private int tempo;//曲速
    private int key;//音调
    private int micset_room_mode;    //音场
    private Timestamp modifytime;    //	修改时间
    private Timestamp createtime;//创建时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getMain_volume() {
        return main_volume;
    }

    public void setMain_volume(int main_volume) {
        this.main_volume = main_volume;
    }

    public int getMusic_volume() {
        return music_volume;
    }

    public void setMusic_volume(int music_volume) {
        this.music_volume = music_volume;
    }

    public int getMicrophone_volume() {
        return microphone_volume;
    }

    public void setMicrophone_volume(int microphone_volume) {
        this.microphone_volume = microphone_volume;
    }

    public int getMicrophone_echo_volume() {
        return microphone_echo_volume;
    }

    public void setMicrophone_echo_volume(int microphone_echo_volume) {
        this.microphone_echo_volume = microphone_echo_volume;
    }

    public int getMelody_volume() {
        return melody_volume;
    }

    public void setMelody_volume(int melody_volume) {
        this.melody_volume = melody_volume;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getMicset_room_mode() {
        return micset_room_mode;
    }

    public void setMicset_room_mode(int micset_room_mode) {
        this.micset_room_mode = micset_room_mode;
    }

    public Timestamp getModifytime() {
        return modifytime;
    }

    public void setModifytime(Timestamp modifytime) {
        this.modifytime = modifytime;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }
}
