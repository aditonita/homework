package homework_12_01_2019;

import java.util.ArrayList;
import java.util.List;

public class VideoStore {

	private List<Video> videoList = new ArrayList<Video>();

	public void addVideo(String videoTitle) {
		videoList.add(new Video(videoTitle));
	}

	public void checkOut(String videoTitle) {

		for (Video video : this.videoList) {
			if (video.getTitle() == videoTitle) {
				if (!(video.isChecked())) {
					video.videoRented();
				}
			}
		}
	}

	public void returnVideo(String videoTitle, String clientName, int rate) {
		for (Video video : this.videoList) {
			if (video.getTitle() == videoTitle) {
				video.videoReturned();
				videoRating(video, clientName, rate);
			}
		}
	}

	private void videoRating(Video video, String client, int rate) {
		video.getVideoRate(client, rate);
	}

	public void listInventory() {
		for (Video video : this.videoList) {
			System.out.println(video.getTitle() + " - " + video.isChecked() + " - " + video.videoRate());
		}
	}
	// : list the whole inventory of videos in the store.

}
