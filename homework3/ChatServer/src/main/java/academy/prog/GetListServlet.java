package academy.prog;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import jakarta.servlet.http.*;

/*

	0 - m / from=0
	1 - m
	2 - m
	....
	100 - m / from=101
	....


 */

public class GetListServlet extends HttpServlet {
	
	private MessageList msgList = MessageList.getInstance();

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/json");
		resp.sendRedirect("get.jsp");
		String fromStr = req.getParameter("from");
		int from = 0;
		try {
			if (fromStr != null){
				from = Integer.parseInt(fromStr);
				if (from <= 0) from = 0;
			}
		} catch (Exception ex) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
		}



		String json = msgList.toJSON(from);
		if (json != null) {
			OutputStream os = resp.getOutputStream();
            byte[] buf = json.getBytes(StandardCharsets.UTF_8);
			os.write(buf);

			//PrintWriter pw = resp.getWriter();
			//pw.print(json);
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/json");

		String fromStr = req.getParameter("from");
		String userStr = req.getParameter("user");
		System.out.println(fromStr);
		System.out.println(userStr);
		int from = 0;
		try {
			if (fromStr != null){
				from = Integer.parseInt(fromStr);
				if (from <= 0 ) from = 0;
			}
		} catch (Exception ex) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}


		String json = msgList.toJSON(0, userStr);
		OutputStream os = resp.getOutputStream();
		if (json != null) {

			byte[] buf = json.getBytes(StandardCharsets.UTF_8);
			os.write(buf);

		}else{
			byte[] buf = "No messages".getBytes(StandardCharsets.UTF_8);
			os.write(buf);
		}
	}
}


