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

public class singer {
	final static int N = 32914898;
	public static void main(String[] args) throws IOException {
		JSONArray jsonA = new JSONArray();
//		for (int n = 1; n <= N; n++) {
		for (int n = (2879819); n <= 2879819; n++) {
			JSONObject jsonO = new JSONObject();
			String URL = "https://www.melon.com/artist/timeline.htm?artistId=" + n;
			Document doc = Jsoup.connect(URL).get();
			Elements temp = doc.select("body div");
			Iterator<Element> e_temp = temp.select("div").iterator();
			String isExist = e_temp.next().attr("id");

			// ���������� ���� ��� pass
			if (isExist.equals("conts"))
				continue;

			// ���������� ���� ��� ũ�Ѹ�
			Elements s1 = doc.select(".wrap_dtl_atist");
			Iterator<Element> e_title = s1.select(".title_atist").iterator(); // ����
			Iterator<Element> e_album = s1.select("#artistImgArea a").iterator(); // �ٹ�����
			Iterator<Element> e_artist = s1.select(".wrap_atistname a").iterator(); // ���
			Iterator<Element> e_info = s1.select(".list dd").iterator(); // �ٹ�, �߸���, �帣
			Iterator<Element> e_like = s1.select(".button_etc.like.type02 .cnt").iterator(); // ���ƿ� ��

			ArrayList<String> list;
			String[] arr;
			String str;
			
			// ������ȣ
			jsonO.put("id", n);
			
			// �뷡�̸�
			str = e_title.next().text();
			str = str.substring(5);
			jsonO.put("title", str);
			
			// �����
			list = new ArrayList<String>();
			while (e_artist.hasNext()) {
				list.add(e_artist.next().attr("title"));
			}
			jsonO.put("artist", list);
			
			// �ٹ�����
			str = e_album.next().attr("src");
			jsonO.put("artist_img", str);
			
			// �ٹ���
			str = e_info.next().text();
			jsonO.put("album", str);
			
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
			
			// FLAC
			str = e_info.next().text();
			jsonO.put("flac", str);
			
			// ���ƿ� ��
			str = e_like.next().text();
			jsonO.put("like", str);
			
			jsonA.add(jsonO);
		}

		// ���Ϸ� ����
		FileWriter file = new FileWriter("C:\\Users\\multicampus\\Desktop\\tes.json");
		file.write(jsonA.toJSONString());
		file.flush();
		file.close();
	}

}
