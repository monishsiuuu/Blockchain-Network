from kafka import KafkaProducer
from . import general


def connect_kafka_producer():
    _producer = None
    try:
        _producer = KafkaProducer(bootstrap_servers=[f'{general.KAFKA_HOST}:{general.KAFKA_PORT}'], api_version=(0, 10))
    except Exception as ex:
        print('Exception while connecting Kafka')
        print(str(ex))
    finally:
        return _producer


def publish_message(topic_name, key, value):
    try:
        key_bytes = bytes(str(key), encoding='utf-8')
        value_bytes = bytes(str(value), encoding='utf-8')
        producer_instance = connect_kafka_producer()
        producer_instance.send(topic_name, key=key_bytes, value=value_bytes)
        producer_instance.flush()
        print('Message published successfully.')
    except Exception as ex:
        print('Exception in publishing message')
        print(str(ex))
