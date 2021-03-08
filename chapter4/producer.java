import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaBookProducer1 {
  public static void main(String[] args) {
    Properties props = new Properties(); // properties Object를 수행함.
    props.put("bootstrap.servers", "peter-kafka001:9092,peter-kafka002:9092,peter-kafka003:9092"); //브로커리스트정의함.1개의 브로커로만 진행했을가능성도 있음
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer"); //메세지의 키와 값의 문자열을 사용할 예정이므로 내장된, StringSerializer를 지정
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

    Producer<String, String> producer = new KafkaProducer<>(props);//Properties 오브젝트를 전달해 새 프로듀서를 생성합니다.
    producer.send(new ProducerRecord<String, String>("peter-topic", "Apache Kafka is a distributed streaming platform")); 
    //producerRecord오브젝으를 생성하고 send() 메소드를 통해 peter-topic 으로 메세지를 전달합니다.
    producer.close();
  }
}
