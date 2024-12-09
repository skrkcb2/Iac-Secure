/*
 * Decompiled with CFR 0.152.
 */
package org.iclass.controller.notice;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaDateTypeTest {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("###,###,###,###");
        long now = System.currentTimeMillis();
        System.out.println("1. \ud604\uc7ac\uc2dc\uac04\uc744 1970\ub144 1\uc6d4 1\uc77c 0\uc2dc\uae30\uc900\uc73c\ub85c \uad6c\ud569\ub2c8\ub2e4. \ub2e8\uc704 : ms(1/1000\ucd08)");
        System.out.println("\ud604\uc7ac \uc2dc\uac04 = " + now + " ms");
        System.out.println("\ud604\uc7ac \uc2dc\uac04 = " + df.format(now) + " ms");
        System.out.println("--- \ud604\uc7ac\uc2dc\uac04\uc744 ms \ub85c \uad6c\ud558\ub294 \ubc29\uc2dd\uc740 \ubaa8\ub4e0 \ud504\ub85c\uadf8\ub798\ubc0d\uc5b8\uc5b4\uc5d0\uc11c \uc0ac\uc6a9\ud569\ub2c8\ub2e4.---");
        System.out.println("\n2. \uc57d 53\ub144\uc744 \uc9c1\uc811 ms \ub85c \uacc4\uc0b0\ud574 \ubd05\ub2c8\ub2e4. ");
        long oneday = 86400000L;
        long oneyear = 365L * oneday;
        System.out.println("1\uc77c 24\uc2dc\uac04 = " + df.format(oneday) + " ms");
        System.out.println("1\ub144 365\uc77c = " + df.format(oneyear) + " ms");
        System.out.println("53\ub144 = " + df.format(53L * oneyear) + " ms");
        System.out.println("54\ub144 = " + df.format(54L * oneyear) + " ms");
        System.out.println("\n3. \ub0a0\uc9dc \ud074\ub798\uc2a4\ub85c \uac1d\uccb4 \uc0dd\uc131\ud569\ub2c8\ub2e4.");
        System.out.println("*java.util.Date \ud074\ub798\uc2a4 : " + String.valueOf(new Date()));
        System.out.println("*java.util.Date \ud074\ub798\uc2a4 getTime() : " + new Date().getTime());
        System.out.println("--------------------------------------------");
        System.out.println("*java.sql.Date \ud074\ub798\uc2a4 : " + String.valueOf(new java.sql.Date(54L * oneyear)));
        System.out.println("*java.sql.Date \ud074\ub798\uc2a4 : " + String.valueOf(new java.sql.Date(new Date().getTime())));
        System.out.println("---------------------------------------------");
        System.out.println("java.util.Calendar \ud074\ub798\uc2a4 : " + String.valueOf(Calendar.getInstance()));
        System.out.println("=> private \uc0dd\uc131\uc790\uc774\uace0 \uac1d\uccb4\ub97c \ub9cc\ub4e4\uc5b4 \uc804\ub2ec\ud574 \uc8fc\ub294 getInstance \uba54\uc18c\ub4dc");
    }
}
