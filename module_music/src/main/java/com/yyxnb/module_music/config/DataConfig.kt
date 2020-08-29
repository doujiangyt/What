package com.yyxnb.module_music.config

import com.yyxnb.common.CommonManager
import com.yyxnb.module_music.bean.MusicBean
import com.yyxnb.network.utils.GsonUtils
import com.yyxnb.utils.FileUtils
import com.yyxnb.widget.WidgetManager
import java.math.BigDecimal
import java.util.*

object DataConfig {
    /**
     * 数据
     *
     * @return
     */
    @JvmStatic
    @Volatile
    var musicBeans: List<MusicBean>? = null
        get() {
            if (field == null) {
                val content = FileUtils.parseFile(WidgetManager.getContext(), "music.json")
                field = GsonUtils.jsonToList(content, MusicBean::class.java)
            }
            Collections.shuffle(field)
            return field
        }
        private set

    fun formatNum(num: Int): String {
        val sb = StringBuilder()
        val b0 = BigDecimal("1000")
        val b1 = BigDecimal("10000")
        val b2 = BigDecimal("100000000")
        val b3 = BigDecimal(num)
        var formatNumStr = ""
        var nuit = ""

//        // 以千为单位处理
//            if (b3.compareTo(b0) == 0 || b3.compareTo(b0) == 1) {
//                return "999+";
//            }

        // 以万为单位处理
        if (b3.compareTo(b1) == -1) {
            sb.append(b3.toString())
        } else if (b3.compareTo(b1) == 0 && b3.compareTo(b1) == 1
                || b3.compareTo(b2) == -1) {
            formatNumStr = b3.divide(b1).toString()
            nuit = "w"
        } else if (b3.compareTo(b2) == 0 || b3.compareTo(b2) == 1) {
            formatNumStr = b3.divide(b2).toString()
            nuit = "e"
        }
        if ("" != formatNumStr) {
            var i = formatNumStr.indexOf(".")
            if (i == -1) {
                sb.append(formatNumStr).append(nuit)
            } else {
                i = i + 1
                val v = formatNumStr.substring(i, i + 1)
                if ("0" != v) {
                    sb.append(formatNumStr.substring(0, i + 1)).append(nuit)
                } else {
                    sb.append(formatNumStr.substring(0, i - 1)).append(nuit)
                }
            }
        }
        return if (sb.length == 0) {
            "0"
        } else sb.toString()
    }
}