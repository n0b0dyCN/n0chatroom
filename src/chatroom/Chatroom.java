/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatroom;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import util.Util;

/**
 *
 * @author owo
 */
public class Chatroom extends javax.swing.JFrame {

    public static boolean isConnected = false;
    public static boolean isClosing = false;

    private String[] userlist;

    private String serverip;
    private short serverport;
    private short localport;
    private DatagramSocket ds;
    private InetAddress addrUDP;
    public static String username;

    private static final int BUFLEN = 65535;

    ArrayList<Socket> chatarray;

    /**
     * Creates new form ChatroomUI
     */
    public Chatroom() {
        initComponents();
        chatarray = new ArrayList<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jIPText = new javax.swing.JTextField();
        jServerPortText = new javax.swing.JTextField();
        jConnectButton = new javax.swing.JButton();
        jStartChatButton = new javax.swing.JButton();
        jUsernameText = new javax.swing.JTextField();
        jLocalPortText = new javax.swing.JTextField();
        jListScroll = new javax.swing.JScrollPane();
        jClientList = new javax.swing.JList<>();
        jLogPanel = new javax.swing.JScrollPane();
        jLogArea = new javax.swing.JTextArea();
        jChatTabPanel = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jIPText.setText("127.0.0.1");

        jServerPortText.setText("9999");

        jConnectButton.setText("connect");
        jConnectButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jConnectButtonMouseClicked(evt);
            }
        });

        jStartChatButton.setText("start chat");
        jStartChatButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jStartChatButtonMouseClicked(evt);
            }
        });

        jUsernameText.setText("owo");

        jLocalPortText.setText("2333");

        jListScroll.setAutoscrolls(true);

        jListScroll.setViewportView(jClientList);

        jLogPanel.setAutoscrolls(true);

        jLogArea.setColumns(20);
        jLogArea.setRows(5);
        jLogPanel.setViewportView(jLogArea);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLogPanel)
                    .addComponent(jListScroll, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jStartChatButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jConnectButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jUsernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jIPText))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jServerPortText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLocalPortText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jServerPortText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIPText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jUsernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLocalPortText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jConnectButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jListScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jStartChatButton)
                .addGap(16, 16, 16)
                .addComponent(jLogPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jChatTabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jChatTabPanel)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jConnectButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jConnectButtonMouseClicked
        // TODO add your handling code here:
        try {
            username = this.jUsernameText.getText();
            localport = Util.string2short(this.jLocalPortText.getText());
            if (isConnected) {
                new UDPConnect().disconnect();
                jClientList.removeAll();
                isConnected = false;
            }
            serverip = this.jIPText.getText();
            serverport = Util.string2short(this.jServerPortText.getText());
            new Thread(new UDPConnect()).start();
            new Thread(new TCPListener()).start();
        } catch (Exception e) {
            Util.error(e.getMessage());
            String msg = "Need to fill server ip, server port, username and ";
            msg += "local port area to join the chat system. The username should";
            msg += " be shorter than 20 characters.";
            this.addLog(msg);
        }
    }//GEN-LAST:event_jConnectButtonMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Chatroom.isClosing = true;
        new UDPConnect().disconnect();
    }//GEN-LAST:event_formWindowClosing

    private void jStartChatButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jStartChatButtonMouseClicked
        // TODO add your handling code here:
        int n_selected = this.jClientList.getSelectedIndices().length;
        if (n_selected != 1) {
            addLog("Select one client a time.");
            return ;
        }
        String selected = this.jClientList.getSelectedValue();
        String selected_uname = selected.split("-> ")[0].replace(Character.toString((char) 0), (String)(""));
        String ip_port = selected.split("-> ")[1].replace(Character.toString((char) 0), (String)(""));
        //Util.info(String.valueOf(selected_uname.length()));
        //Util.info(String.valueOf(username.length()));
        if (selected_uname.equals(username)) {
            addLog("Cannot connect to yourself.");
            return;
        }
        String conn_ip = ip_port.split(":")[0];
        short conn_port = Util.string2short(ip_port.split(":")[1]);
        addLog("connect to " + conn_ip + " port: " + conn_port);
        addChatPanel(conn_ip, conn_port, selected_uname);
    }//GEN-LAST:event_jStartChatButtonMouseClicked

    private void addChatPanel(Socket sock) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            String date = new Date().toString();
            md.update(date.getBytes());
            String suffix = new BigInteger(1, md.digest()).toString(16);
            addChatPanel(sock, "Unknown" + Util.slice(suffix, 0, 3));
        } catch (Exception e) {
            addLog("Fail to generate random name.");
        }
    }

    private void addChatPanel(String ip_, short port_, String target_name){
        try {
            Socket sock = new Socket(ip_, port_);
            addChatPanel(sock, target_name);
        } catch (Exception e) {
            addLog("Fail to get socket");
        }
    }

    private void addChatPanel(Socket sock, String target_name){
        chatarray.add(sock);
        ChatPanel cp = new ChatPanel(sock, target_name);
        jChatTabPanel.addTab(target_name, cp);

        addLog("Connected with [" + sock.getInetAddress().getHostAddress() + ":" + sock.getPort() + "]");

        // add disconnect button
        int index = jChatTabPanel.indexOfTab(target_name);
        JPanel pnlTab = new JPanel(new GridBagLayout());
        pnlTab.setOpaque(false);
        JLabel lblTitle = new JLabel(target_name);
        JButton btnClose = new JButton("x");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
            
        pnlTab.add(lblTitle, gbc);
            
        gbc.gridx++;
        gbc.weightx = 0;
        pnlTab.add(btnClose, gbc);
            
        jChatTabPanel.setTabComponentAt(index, pnlTab);
        btnClose.addActionListener(new ChatPanelCloseActionHandler(target_name));
    }

    private void addLog(String msg) {
        this.jLogArea.append(msg + '\n');
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Chatroom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chatroom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chatroom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chatroom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Chatroom cr = new Chatroom();
                cr.setVisible(true);
                cr.setTitle("Chatroom");
            }
        });
    }

    public void setUserlist(String[] userlist_) {
        userlist = userlist_;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jChatTabPanel;
    private javax.swing.JList<String> jClientList;
    private javax.swing.JButton jConnectButton;
    private javax.swing.JTextField jIPText;
    private javax.swing.JScrollPane jListScroll;
    private javax.swing.JTextField jLocalPortText;
    private javax.swing.JTextArea jLogArea;
    private javax.swing.JScrollPane jLogPanel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jServerPortText;
    private javax.swing.JButton jStartChatButton;
    private javax.swing.JTextField jUsernameText;
    // End of variables declaration//GEN-END:variables

    /* The following classes are used to keep communication with server.
     * UDPConnect: send login message to server.
     * UDPReceive: loop to get userlist from server and update userlist
     */

    class UDPConnect implements Runnable {
        public UDPConnect() {
            try {
                addrUDP = InetAddress.getByName(serverip);
                ds = new DatagramSocket(localport);
            } catch (Exception e) {
                Util.error("[Connect thread] Fail to create InetAddress"+
                                    "[" + serverip + ":" + serverport + "]");
            }
        }

        public int sendUDP(byte[] msg) {
            try {
                DatagramPacket udpSend = new DatagramPacket(msg, msg.length, addrUDP, serverport);
                ds.send(udpSend);
            } catch (Exception e) {
                Util.error("[Connect thread] Failed to send udp packet:" + e.getMessage());
                return -1;
            }
            return 0;
        }

        public int connect() {
            if (username.length() > 20) {
                Util.error("[Connect thread] Too long name!");
                return -1;
            }
            byte[] msg = new byte[1];
            msg[0] = Util.C_LOGIN;
            msg = Util.concat(msg, Util.short2byte(localport));
            msg = Util.concat(msg, username.getBytes());
            msg = Util.extend(msg, Util.LEN_LOGIN_REQUEST);
            return sendUDP(msg);
        }

        public int disconnect() {
            byte[] msg = new byte[1];
            msg[0] = Util.C_QUIT;
            return sendUDP(msg);
        }

        @Override
        public void run() {
            String key = serverip + ":" + String.valueOf(serverport);
            while (true) {
                try {
                    if (Chatroom.isClosing) {
                        break;
                    }
                    if (key == serverip + ":" + String.valueOf(serverport))
                        break;
                    if (Chatroom.isConnected)
                        break;
                    while(connect() < 0);
                    Chatroom.isConnected = true;
                    addLog("Connected to server " + key);
                    new Thread(new UDPReceive()).start();
                    break; // connect only once
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    break; // connect only once
                }
            }
            
        }
    }

    class UDPReceive implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    byte[] buf = new byte[BUFLEN];
                    DatagramPacket packet = new DatagramPacket(buf, buf.length);
                    ds.receive(packet);
                    byte[] received = packet.getData();
                    int code = parse(received);
                    if (code == Util.C_QUIT_ACK) {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        private int parse(byte[] buf) {
            switch (buf[0]) {
                case Util.C_CLI_LIST_UPDATE:
                case Util.C_CLI_LIST:
                    int n_records = Util.byte2int(Util.slice(buf, 1, 1+4));
                    //Util.info("[Parser]" + n_records + " records received.");
                    int p = 5;
                    userlist = new String[n_records];
                    jClientList.removeAll();
                    for (int i = 0; i < n_records; i++) {
                        String r_ip = Util.byte2ip(Util.slice(buf, p, p+4));
                        p += 4;
                        short r_port = Util.byte2short(Util.slice(buf, p, p+2));
                        p += 2;
                        String r_username = new String(Util.slice(buf, p, p+20));
                        p += 20;
                        String r_record = r_username + "-> " + r_ip + ":" + String.valueOf(r_port);
                        userlist[i] = r_record;
                        //Util.info("Parsed: " + r_record);
                    }
                    jClientList.setListData(userlist);
                    break;
                case Util.C_QUIT_ACK:
                    //Util.info("Quit.");
                    break;
                case Util.C_UNRECOGNIZED:
                    Util.error("Server cannot understand the request.");
                    break;
                default:
                    break;
            }
            return buf[0];
        }

    }

    class TCPListener implements Runnable {

        @Override
        public void run() {
            try {
                ServerSocket ss = new ServerSocket(localport);
                while (true) {
                    if (Chatroom.isClosing) {
                        break;
                    }
                    Util.info("Listening at port" + localport);
                    Socket sock = ss.accept();
                    addChatPanel(sock);
                }
            } catch (Exception e) {
                Util.error(e.getMessage());
            }
        }
        
    }


    class ChatPanelCloseActionHandler implements ActionListener {

        private String tabName;

        public ChatPanelCloseActionHandler(String tabName) {
            this.tabName = tabName;
        }

        public String getTabName() {
            return this.tabName;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            int index = jChatTabPanel.indexOfTab(getTabName());
            if (index >= 0) {
                Socket sock = chatarray.get(index);
                try {
                    OutputStream send = sock.getOutputStream();
                    String msg = "finish" + Character.toString((char) 0);
                    send.write(msg.getBytes());
                    sock.close();
                    chatarray.remove(index);
                } catch (Exception ex) {}
                jChatTabPanel.removeTabAt(index);
            }
        }
    }

}