package consumer;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;
import javax.swing.JTextArea;
 
public class ConsumerMessageListener implements MessageListener {
    private JTextArea text;
 
    public ConsumerMessageListener(JTextArea text) {
        this.text = text;
    }
 
    public void onMessage(Message msg) {
    	//msg là message nhận được
		try {
			if(msg instanceof TextMessage){
				TextMessage tm=(TextMessage)msg;
				String txt=tm.getText();
				text.setText(txt);
				System.out.println(txt);
				msg.acknowledge();//gửi tín hiệu ack
			}
			else if(msg instanceof ObjectMessage){
				ObjectMessage om=(ObjectMessage)msg;
				System.out.println(om);
			}
			//others message type....
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
 
}
