package mocklab.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * 
 * @author 黄谦
 *
 */
public class BomHelper {

	public static boolean isBomWithinUTF8(InputStream in) throws IOException {
		InputStreamReader FS;
		try {
			FS = new InputStreamReader(in, "UTF-8");
		BufferedReader SR = new BufferedReader(FS); // 文件输入流为
		String strLine = SR.readLine();
		if (strLine.length() > 1) {
			if ((int) strLine.charAt(0) == 65279) {
				return true;
			}
			}
		} catch (UnsupportedEncodingException e) {
			throw new IOException("utf-8 does not match the input....");
		} catch (IOException ioe ) {
			throw new IOException("error occur during reading line from input.....");
		}
		return false;
	}
}
