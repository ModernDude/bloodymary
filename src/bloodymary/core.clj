(ns bloodymary.core
  (:require [bloodymary.mary :as mary])
  (:require [pynch.core :as py])
  (:gen-class))

(def go-on? (atom true))
(def *max-queue-length* 4)
(def queue (java.util.concurrent.LinkedBlockingQueue. *max-queue-length*))
(def output (ref ()))
(def *def-url* "http://news.ycombinator.com")

(defn overseer
  ([] (overseer 20000))
  ([timeout]
     (Thread/sleep timeout)
     (swap! go-on? not)))

(defn get-sub-links [url]
  "Get all submission links at the given url"
  (map :sub-url (py/get-subs (java.net.URI. url))))

(defn get-sub-strings [url]
  

(defn get-text [site-url]
  (doseq [sub-url (cycle get-sub-links site-url)])
  (cycle (py/get-subs (java.net.URI. *def-url*)))
  )Ta


(defn producer [tag]
  (future
   (while @go-on?
     (.put queue tag)
     (Thread/sleep (rand-int 2000)))))

(defn consumer []
  (future
   (while @go-on?
     ;; I'm using .poll on the next line so as not to block
     ;; indefinitely if we're done; note that this has the
     ;; side effect that nulls = nils on the queue will not
     ;; be handled; there's a number of other ways to go about
     ;; this if this is a problem, see docs on LinkedBlockingQueue
     (when-let [item (.poll queue)]
       (Thread/sleep (rand-int 500)) ; do stuff
       (dosync (alter output conj item)))))) ; and let us know

(defn pro-con []
  (reset! go-on? true)
  (dorun (map #(%1 %2)
              (repeat 5 producer)
              (iterate inc 0)))
  (dorun (repeatedly 2 consumer))
  (overseer))

;; HN


;; GSTREAM

;;; MARY




(defn -main [& args]
  (println "sdfds"))


