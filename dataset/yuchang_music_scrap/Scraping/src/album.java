import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class album {
	final static int N = 10488015;
	public static void main(String[] args) throws IOException {
		JSONArray jsonA = new JSONArray();
//		for (int n = 1; n <= N; n++) {
		for (int n = 10469414; n <= 10469414; n++) {
			JSONObject jsonO = new JSONObject();
			String URL = "https://www.melon.com/album/detail.htm?albumId=" + n;
			Document doc = Jsoup.connect(URL).get();
			Elements temp = doc.select("body div");
			Iterator<Element> e_temp = temp.select("div").iterator();
			String isExist = e_temp.next().attr("id");

			// �ٹ������� ���� ��� pass
			if (isExist.equals("conts"))
				continue;

			// �ٹ������� ���� ��� ũ�Ѹ�
			System.out.println();
			Elements s1 = doc.select(".section_info");
			Elements s2 = doc.select(".section_albuminfo");
			Iterator<Element> e_title = s1.select(".song_name").iterator(); // ����
			Iterator<Element> e_album = s1.select(".image_typeAll img").iterator(); // �ٹ�����
			Iterator<Element> e_artist = s1.select(".artist a").iterator(); // ����
			Iterator<Element> e_info = s1.select(".list dd").iterator(); // �ٹ�, �߸���, �帣
			Iterator<Element> e_like = s1.select(".button_etc.like.type02 .cnt").iterator(); // ���ƿ� ��
			Iterator<Element> e_lyric = s2.select("#d_video_summary div").iterator(); // �ٹ��Ұ�

			ArrayList<String> list;
			String[] arr;
			String str;
			
			// �ٹ���ȣ
			jsonO.put("id", n);
			
			// �ٹ���
			str = e_title.next().text();
			str = str.substring(4);
			jsonO.put("title", str);
			
			// ����
			list = new ArrayList<String>();
			while (e_artist.hasNext()) {
				list.add(e_artist.next().attr("title"));
			}
			jsonO.put("artist", list);
			
			// �ٹ�����
			str = e_album.next().attr("src");
			jsonO.put("album_img", str);
			
			// �߸���
			str = e_info.next().text();
			jsonO.put("date", str);
			
			// �帣
			arr = e_info.next().text().split(", ");
			list = new ArrayList<String>();
			for (int i = 0; i < arr.length; i++) {
				list.add(arr[i]);
			}
			jsonO.put("genre", list);
			
			// �߸Ż�
			str = e_info.next().text();
			jsonO.put("publisher", str);
			
			// ��ȹ��
			str = e_info.next().text();
			jsonO.put("agency", str);
			
			// ���ƿ� ��
			str = e_like.next().text();
			jsonO.put("like", str);
			
			// �ٹ��Ұ�
			str = e_lyric.next().text();
			jsonO.put("info", str);
			
			jsonA.add(jsonO);
		}
		System.out.println(jsonA);
		// ���Ϸ� ����
		FileWriter file = new FileWriter("C:\\Users\\multicampus\\Desktop\\album.json");
		file.write(jsonA.toJSONString());
		file.flush();
		file.close();
	}

}
