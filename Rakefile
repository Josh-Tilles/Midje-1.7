# -*- Mode: ruby -*-

require 'rubygems'
require 'rake'

def jar_name
  text = File.read('project.clj')
  unless / midje\s+"(\d+\.\d+.\d+)"/ =~ text ||
         / midje\s+"(\d+\.\d+(-RC\d+)?)"/ =~ text ||
         / midje\s+"(\d+\.\d+(\.\d+)*-SNAPSHOT)"/ =~ text || 
         / midje\s+"(\d+\.\d-alpha\d+)"/ =~ text || 
         / midje\s+"(\d+\.\d-beta\d+)"/ =~ text
    puts "Rake task error: couldn't find version in project file."
    exit 1
  end
  jar = "midje-#{$1}.jar"
  puts "jar name: #{jar}"
  jar
end

def doit(text)
    puts "== " + text
    system(text)
end

task :default => :fresh

desc "Test a fresh build, manual checking for now"
task :fresh do
     doit("lein clean")
     doit("lein jar")
end

task :jar_name do 
  puts jar_name
end

desc "upload to clojars"
task :upload => [:fresh] do
  doit("lein deploy clojars")
end

task :deploy => [:upload]

desc "Check many versions of Clojure"
task :compatibility do
  doit("lein compatibility")
end
