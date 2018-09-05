#! /bin/sh
file_list=`ls /d/Article_html/`
for file in $file_list
do 
	pandoc -f html '/d/Article_html/'$file -t docx -o '/d/art/'${file%.*}.docx
done
