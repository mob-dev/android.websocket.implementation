import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class MainActivity extends AppCompatActivity {
  private static WebSocket webSocket;
  private OkHttpClient okHttpClient;
  private CustomWebSocketListener customWebSocketListener;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.okHttpClient = new OkHttpClient();
    this.customWebSocketListener = new CustomWebSocketListener();
    this.initializeWebSocket();
  }

  private void initializeWebSocket() {
   String url = "websocketurl";
    Request request = new Request.Builder().url(url).build();
    webSocket = this.okHttpClient.newWebSocket(request, this.customWebSocketListener);
    this.okHttpClient.dispatcher().executorService().shutdown();
  }

  public static void forceCloseWebsocketConnection() {
      if (webSocket != null) {
          webSocket.close(1000, null);
      }
  }


    private class CustomWebSocketListener extends WebSocketListener {
        @Override
        public void onOpen(WebSocket webSocket, Response response) {
        }

        @Override
        public void onMessage(WebSocket webSocket, String socketMessage) {
          
        }

        @Override
        public void onClosing(WebSocket webSocket, int code, String reason) {
            
        }

        @Override
        public void onFailure(WebSocket webSocket, Throwable t, Response response) {
            
        }

        @Override
        public void onClosed(WebSocket webSocket, int code, String reason) {
            super.onClosed(webSocket, code, reason);
        }
    }
}
