package com.example.websocket;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import org.jwebsocket.api.WebSocketClientEvent;
import org.jwebsocket.api.WebSocketClientTokenListener;
import org.jwebsocket.api.WebSocketPacket;
import org.jwebsocket.client.plugins.rpc.Rpc;
import org.jwebsocket.client.plugins.rpc.RpcListener;
import org.jwebsocket.client.plugins.rpc.Rrpc;
import org.jwebsocket.client.token.BaseTokenClient;
import org.jwebsocket.token.Token;
 
import android.app.Activity;
import android.os.Bundle;
import android.os.Message;

public class MainActivity extends Activity implements WebSocketClientTokenListener{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abc_action_bar_decor);
 
        BaseTokenClient btc = new BaseTokenClient();//create a new instance os the base token client
        btc.addListener(this);//add this class as a listener
        btc.addListener(new RpcListener());//add an rpc listener
        Rpc.setDefaultBaseTokenClient(btc);//set it to the default btc
        Rrpc.setDefaultBaseTokenClient(btc);//same here
        try{
            System.out.println("connecting...");//debug
            btc.open("ws://79.193.237.232:8787/jWebSocket/jWebSocket");//try to open the connection to your server
        }catch(Exception e){
            System.out.println("Error while connecting...");//debug errors
        }
 
    }
 
    @Override
    public void processOpened(WebSocketClientEvent aEvent) {
        System.out.println("Client is connected");//if the connection is established
    }
 
    @Override
    public void processClosed(WebSocketClientEvent aEvent) {
        System.out.println("Client is disconnected");//if the connection is closed
    }
 
        /* The following Methods are not needed now, but have to be there */
    @Override
    public void processPacket(WebSocketClientEvent aEvent, WebSocketPacket aPacket) {
    }
 
    @Override
    public void processToken(WebSocketClientEvent aEvent, Token aToken) {
    }
 
    @Override
    public void processOpening(WebSocketClientEvent aEvent) {
    }
 
    @Override
    public void processReconnecting(WebSocketClientEvent aEvent) {
    }
}
