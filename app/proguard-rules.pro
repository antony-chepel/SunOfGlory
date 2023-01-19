#AppsFlyer
-keep class com.appsflyer.** { *; }
-keep public class com.android.installreferrer.** { *; }

#Ktor with Serializable
-if @kotlinx.serialization.Serializable class **
-keepclassmembers class <1> {
   static <1>$Companion Companion;
}

-if @kotlinx.serialization.Serializable class ** {
   static **$* *;
}
-keepclassmembers class <2>$<3> {
   kotlinx.serialization.KSerializer serializer(...);
}


-if @kotlinx.serialization.Serializable class ** {
   public static ** INSTANCE;
}
-keepclassmembers class <1> {
   public static <1> INSTANCE;
   kotlinx.serialization.KSerializer serializer(...);
}

-keepattributes RuntimeVisibleAnnotations,AnnotationDefault
-keepclassmembers class io.ktor.** { volatile <fields>; }


#Onesignal
-dontwarn com.onesignal.**
-keep class com.onesignal.ActivityLifecycleListenerCompat** {*;}


#Coroutines
-keep class kotlinx.coroutines.**
-dontwarn kotlinx.coroutines.**