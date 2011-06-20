(ns bloodymary.mary
  (:import
   (marytts.client MaryClient MaryClient$AudioPlayerListener)
   (marytts.client.http Address)
   (marytts.util.data.audio AudioPlayer)
   (java.io ByteArrayInputStream ByteArrayOutputStream)))


(def *host* "localhost")
(def *port* 59125)
(def *input-type* "TEXT")
(def *audio-type* "AU")
(def *locale* "en_GB")
(def *voice-name* "dfki-spike-hsmm")
(def *style* "")
(def *effects* "")

  
(defn- get-client [host port]
  (MaryClient/getMaryClient (Address. host port)))

(defn play-audio [s & options]
  " "
  (let [opts (apply hash-map options)]
    (.streamAudio
     (get-client
      (get opts :host *host*)
      (get opts :port *port*))
     s
     (get opts :input-type *input-type*)
     (get opts :locale *locale*)
     (get opts :audio-type *audio-type*)
     (get opts :voice-name *voice-name*)
     (get opts :style *style*)
     (get opts :effects *effects*)
     (AudioPlayer.)
     (proxy [MaryClient$AudioPlayerListener] []))))

(defn get-audio [s & options]
  (let [stream (ByteArrayOutputStream.)
        opts (apply hash-map options)
        client (get-client
                (get opts :host *host*)
                (get opts :port *port*))]
    (.process
     client s
     (get opts :input-type *input-type*)
     "AUDIO"
     (get opts :locale *locale*)
     (get opts :audio-type *audio-type*)
     (get opts :voice-name *voice-name*)
     stream)
    (.toByteArray stream)))
              
