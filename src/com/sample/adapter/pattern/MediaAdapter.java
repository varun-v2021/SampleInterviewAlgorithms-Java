package com.sample.adapter.pattern;

public class MediaAdapter implements MediaPlayer {

	AdvancedMediaPlayer advancedMusicPlayer;
	
	public MediaAdapter(String audioType) {
		if(audioType.equals("vlc"))
			advancedMusicPlayer = new VLCPlayer();
		else if(audioType.equals("mp4"))
			advancedMusicPlayer = new MP4Player();
	}
	
	@Override
	public void play(String audioType, String fileName) {
		if(audioType.equals("vlc"))
			advancedMusicPlayer.playVLC(fileName);
		else if(audioType.equals("mp4"))
			advancedMusicPlayer.playMP4(fileName);
	}

}
