(defproject bloodymary "1.0.0-SNAPSHOT"
  :description "App"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "same as Clojure"}
  :dependencies [[org.clojure/clojure "1.2.1"]
                 [com.googlecode.gstreamer-java/gstreamer-java "1.4"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [log4j "1.2.15" :exclusions
                  [javax.mail/mail
                   javax.jms/jms
                   com.sun.jdmk/jmxtools
                   com.sun.jmx/jmxri]]
                 [diffbot "1.0.0-SNAPSHOT"]
                 [org.clojars.jeffsigmon/maryclient "4.3.0"]
                 [pynch  "0.1.0-alpha"]]
  :dev-dependencies [[swank-clojure "1.2.1"]]
  :main bloodymary.core)
