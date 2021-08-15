#!/bin/bash
  
##Define variables
DIR_TO_SEARCH="./"
STRINGS_TO_SEARCH="test red and demo file read open glass tour"
TEMP_=`mktemp`

if [ "$#" -ne 1 ];
        then
                echo "Usage: $0 <dir to search>"
                echo "Do you want to search current directory? [y/n]"
                read userOption
                if [ $userOption = "n" ];
                then
                        exit 2
                else echo " "
                fi
fi

        cd $DIR_TO_SEARCH
        rm -rf $TEMP_
        echo "Searching ..."
        for STRING in $STRINGS_TO_SEARCH; do
                echo -n "$STRING " >> $TEMP_ ; cat * | grep -o $STRING | wc -l >> $TEMP_
        done

        cat $TEMP_ | sort -r -k2
        echo " "
        echo "Total files searched: "; ls | wc -l
        rm -rf $TEMP_
