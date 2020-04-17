#! /bin/bash
# remove the allof line, we will use java inheritance to get the 
rm -Rf tmp
mkdir tmp
cp ../json_schema/resource.json ../json_schema/language.json ../json_schema/metaLanguage.json ../json_schema/user.json ../json_schema/author.json ../json_schema/citation.json ../json_schema/resourceReference.json ./tmp
quicktype -s schema ./tmp/resource.json -o ./Resource.java

declare -a resourceTypes=("Term" "Proposition" "Argument" "Beliefset" "Article" "Project")
java_path="src/main/java/org/sophize/data"

for i in "${resourceTypes[@]}"
do
   echo "$i"
   original_json="../json_schema/${i,,}.json"
   tmp_json="tmp/${i,,}.json"
   tmp_java="tmp/$i.java"
   final_java="$java_path/$i.java"
   sed 's/.*allOf.*/"type":"object",/' $original_json > $tmp_json
   quicktype -s schema $tmp_json -o $tmp_java --package org.sophize.data
   sed '/public class/ s/{$/extends Resource {/' $tmp_java > $final_java
done

declare -a otherTypes=("Author" "Citation" "Language" "MetaLanguage" "Resource" "User")

for i in "${otherTypes[@]}"
do
   echo "other:$i"
   original_json="../json_schema/${i,}.json"
   final_java="$java_path/$i.java"
   quicktype -s schema $original_json -o $final_java --package org.sophize.data
done

rm -Rf tmp
rm *.java
