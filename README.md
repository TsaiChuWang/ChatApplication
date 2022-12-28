<!--
 * @Author: TsaiChuWang wtsaichu@gmail.com
 * @Date: 2022-12-05 21:39:09
 * @LastEditors: TsaiChuWang wtsaichu@gmail.com
 * @LastEditTime: 2022-12-08 15:07:47
 * @FilePath: /workspace/E-Android Studio/ChatApplication/README.md
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
# ChatApplication 聊癒

第三組 111 行動裝置程式設計的期末作業

**指導老師：** [黃朝曦 教授](https://csie.niu.edu.tw/index.php?Plugin=o_niu&Action=o_niutchdetail&niuid=chhuang)

組員：

| 姓名　|　學號　|
| :--: | :--: |
| 蔡馥伃 | B0843009 |
| 王采筑 | B0843027 |


- - -

# 警示（助教可以略過）

### 給過路的人

這是 111 行動裝置程式設計的期末作業，個人期末請不要下載QAQ

### For passers-by

This is the final assignment of 111 Mobile Device Programming, please do not download QAQ at the end of the semester

### Für Passanten

Dies ist die letzte Aufgabe von 111 Mobile Device Programming, bitte laden Sie die QAQ am Ende des Semesters nicht herunter

### 通行人のために

これは 111 モバイル デバイス プログラミングの最終課題です。学期末に QAQ をダウンロードしないでください。

- - -

# 給助教的說明

### 1. 關於簡報

在「簡報資料夾」裡面

因為拍片的原因都是離散的簡報，主要簡報名稱為「聊癒」

其他依照編號為拍片簡報

PPT預報的簡報為「聊癒：預報」

### 2. 關於APP專案

現在看到的本身就是APP專案的資料夾

在Old_Version可以看到以前舊的版本

如果希望不要有雜七雜八的檔案（例如：簡報跟影片），可以下載「ChatApplication」這個資料夾

### 3. 關於伺服器

架在局域網，伺服器作業系統是MX Linux Debian 5.10.140-1 (2022-09-02) x86_64 GNU/Linux

在Server資料夾包括

**局域網測試用的在Server_Folder裡面**

參考的Github項目下載，也有失敗的

Webocket: WebRTC(失敗) NodeJS（成功） Java(成功)

Http: python RESTful API(現在正在用) Fast API(不建議用但是可以用)

Database:MongoDB(外部伺服器使用) csv(建議不要用)

### 4. 關於版本

在Old_Version資料夾內是舊的版本，可以掠過

真正的，期末用到的是[ChatApplication](https://github.com/TsaiChuWang/ChatApplication/tree/main/ChatApplication)

### 5. 關於繳交

這個項目包含：

1. 完整Project以及更新版本
2. Server的資料
3. 簡報內是報告(含預報告)
4. 部份影片素材
5. Youtube [影片連結](https://www.youtube.com/watch?v=J8f1g3h9Vww&ab_channel=%E8%94%A1%E9%A6%A5%E4%BC%83)

作為期末繳交的資料，麻煩助教了

### 7. 關於APK

名稱叫做 [app-debug.apk]

- - -

# 目的Purpose

這是 第三組 111 行動裝置程式設計的期末作業

對於想要認真撰寫一個聊天APP的人，我建議**不要**下載這份專案，因為程式碼大部分沒寫註解

## Usage scenarios

111 行動裝置程式設計，只適用於這堂課，請注意 111

## how to use

使用 Android Studio 開啟專案，並且使用 Android 12 以上的手機或是模擬器進行測試

## Implementation and related details

詳情見「簡報/聊癒.pptx」

# 功能描述 Functional description

## 註冊 Register

使用電話號碼建立帳號，需要填寫電話號碼 暱稱 密碼以及性別

## 登入 Login

使用電話號碼登入帳號，輸入錯誤會顯示Tiast訊息

## 聯絡人 Contact

檢視聯絡人：以RecyclerView+AppBarLayout顯示
新增聯絡人：使用AlterDialog.Builder，輸入電話後新增（對方不用同意）
搜尋聯絡人：找到聯絡簿內的聯絡人

## 聊天 Chatroom

即時通訊（也就是一般聊天室）

##　影片 Video

在該App裡面觀看Youtube

## 團購 Group Buying

訂單列表以及詳情（只顯示你跟你好友的）

# 開發環境 Development environment

Build #AI-213.7172.25.2113.9123335, built on September 30, 2022

## Android Studio
Runtime version: 11.0.13+0-b1751.21-8125866 amd64
VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.

## Server
MX Linux Debian 5.10.140-1 (2022-09-02) x86_64 GNU/Linux
Windows 10.

## 測試環境

### 實體手機

Samaoung Galaxy A53
Android 13

### 虛擬機

Nexus SX API 33
1080 x 1920

## 項目結構簡介 Introduction to project structure

├── Readme.md                   // help

├── .gradle

├── .idea                       // Libraries 之類的東西

├── app                         // 存放程式

├── ChatApplication             //沒有雜物的專案

├── gradle

├── images                      // APP裡面的圖片

├── Olde_Version                //存放舊版本

├──  Server_Folder              //局域網用的伺服器資料夾

├── 簡報                         // 報告用的簡報
    ├── 聊癒.pptx                //主要用的PPT

├── 素材Matrial                  // APP裡面的圖片來源或是報告的一些圖


└── app-debug.apk               // 當前版本apk檔案

## 作者列表 Author list

指導老師：
黃朝曦 副教授，國立宜蘭大學 資訊工程學系,email: chhuang@niu.edu.tw

學生：
蔡馥伃，國立宜蘭大學 資訊工程學系,email: afiop1010817117802@gmail.com
王采筑, 國立宜蘭大學 資訊工程學系,email: wtsaichu@gmail.com

## 更新日誌

Designed communication software for the elderly, it is the final assignment of the mobile device (Master)

**5 Dezember 2022** 更新聯絡人界面，列表可以滑動跟進行個別反應

**5 Dezember 2022** Update the contact interface, the list can be swipe to follow individual responses

**6 Dezember 2022** 更新聊天室列表

**6 Dezember 2022** Update chat room list

**7 Dezember 2022** 更新團購訂單列表

**7 Dezember 2022** Update group purchase order list

**8 Dezember 2022** 新分支:Interface_Only 保存現在版本

**8 Dezember 2022** New Branch Interface_Only in order to save the version now

**27 Dezember 2022** 上傳期末檔案