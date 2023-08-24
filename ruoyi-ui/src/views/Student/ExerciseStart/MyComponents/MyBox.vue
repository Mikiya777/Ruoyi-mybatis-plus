<template>
  <div>
    <schedule/>

    <!--
      在图片上包上v-if，实现懒加载，以减轻服务器和浏览器压力
    -->

  <!--开始-->
  <div>
    <!--准备阶段-->
    <div>
      <div v-show="controlNumber ===1" class="box-div">
        <img v-if="controlNumber ===1" src="../MyComponents/assets/Preparation/image/01.png" alt="img">

        <audio ref="audioPlayer1" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===2" class="box-div">
        <img v-if="controlNumber ===2" src="../MyComponents/assets/Preparation/image/02.png" alt="img">

        <audio ref="audioPlayer2" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===3" class="box-div">
        <img v-if="controlNumber ===3" src="../MyComponents/assets/Preparation/image/03.png" alt="img">

        <audio ref="audioPlayer3" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===4" class="box-div">
        <img v-if="controlNumber === 4" src="../MyComponents/assets/Preparation/image/04.png" alt="img">

        <audio ref="audioPlayer4" controls autoplay class="video">
          <source v-if="controlNumber === 4" src="../MyComponents/assets/Preparation/audio/04.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===5" class="box-div">
        <img v-if="controlNumber === 5" src="../MyComponents/assets/Preparation/image/05.png" alt="img">

        <audio ref="audioPlayer5" controls autoplay class="video">
          <source v-if="controlNumber === 5" src="../MyComponents/assets/Preparation/audio/05.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===6" class="box-div">
        <img v-if="controlNumber ===6" src="../MyComponents/assets/Preparation/image/06填空.png" alt="img">

        <div>
<!--          <my-test :></my-test>-->
        </div>
        <audio ref="audioPlayer6" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===7" class="box-div">
        <img v-if="controlNumber === 7" src="../MyComponents/assets/Preparation/image/07.png" alt="img">

        <audio ref="audioPlayer7" controls autoplay class="video">
          <source v-if="controlNumber === 7" src="../MyComponents/assets/Preparation/audio/07.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===8" class="box-div">
        <img v-if="controlNumber ===8" src="../MyComponents/assets/Preparation/image/08多选.png" alt="img">

        <audio ref="audioPlayer8" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===9" class="box-div">
        <img  v-if="controlNumber ===9" src="../MyComponents/assets/Preparation/image/09.png" alt="img">

        <audio ref="audioPlayer9" controls autoplay class="video">
          <source v-if="controlNumber === 9" src="../MyComponents/assets/Preparation/audio/09.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===10" class="box-div">
        <img v-if="controlNumber === 10" src="../MyComponents/assets/Preparation/image/10.png" alt="img">

        <audio ref="audioPlayer10" controls autoplay class="video">
          <source v-if="controlNumber === 10" src="../MyComponents/assets/Preparation/audio/10.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===11" class="box-div">
        <img v-if="controlNumber ===11" src="../MyComponents/assets/Preparation/image/11填空.png" alt="img">

        <audio ref="audioPlayer11" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===12" class="box-div">
        <img v-if="controlNumber ===12" src="../MyComponents/assets/Preparation/image/12.png" alt="img">

        <audio ref="audioPlayer12" controls autoplay class="video">
          <source v-if="controlNumber === 12" src="../MyComponents/assets/Preparation/audio/12.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===13" class="box-div">
        <img v-if="controlNumber ===13" src="../MyComponents/assets/Preparation/image/13单选题.png" alt="img">

        <audio ref="audioPlayer13" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===14" class="box-div">
        <img v-if="controlNumber === 14" src="../MyComponents/assets/Preparation/image/14.png" alt="img">

        <audio ref="audioPlayer14" controls autoplay class="video">
          <source v-if="controlNumber === 14" src="../MyComponents/assets/Preparation/audio/14.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===15" class="box-div">
        <img v-if="controlNumber === 15" src="../MyComponents/assets/Preparation/image/15.png" alt="img">

        <audio ref="audioPlayer15" controls autoplay class="video">
          <source v-if="controlNumber === 15" src="../MyComponents/assets/Preparation/audio/15.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===16" class="box-div">
        <img v-if="controlNumber ===16" src="../MyComponents/assets/Preparation/image/16填空.png" alt="img">

        <audio ref="audioPlayer16" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===17" class="box-div">
        <img v-if="controlNumber ===17" src="../MyComponents/assets/Preparation/image/17.png" alt="img">

        <audio ref="audioPlayer17" controls autoplay class="video">
          <source v-if="controlNumber === 17" src="../MyComponents/assets/Preparation/audio/17.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===18" class="box-div">
        <img src="../MyComponents/assets/Preparation/image/18多选.png" alt="img">

        <audio ref="audioPlayer18" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===19" class="box-div">
        <img src="../MyComponents/assets/Preparation/image/19.png" alt="img">

        <audio ref="audioPlayer19" controls autoplay class="video">
          <source v-if="controlNumber === 19" src="../MyComponents/assets/Preparation/audio/19.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===20" class="box-div">
        <img src="../MyComponents/assets/Preparation/image/20.png" alt="img">

        <audio ref="audioPlayer20" controls autoplay class="video">
          <source v-if="controlNumber === 20" src="../MyComponents/assets/Preparation/audio/20.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===21" class="box-div">
        <img src="../MyComponents/assets/Preparation/image/21填空.png" alt="img">

        <audio ref="audioPlayer21" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===22" class="box-div">
        <img src="../MyComponents/assets/Preparation/image/22.png" alt="img">

        <audio ref="audioPlayer22" controls autoplay class="video">
          <source v-if="controlNumber === 22" src="../MyComponents/assets/Preparation/audio/22.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===23" class="box-div">
        <img src="../MyComponents/assets/Preparation/image/23单选.png" alt="img">

        <audio ref="audioPlayer23" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===24" class="box-div">
        <img src="../MyComponents/assets/Preparation/image/24.png" alt="img">

        <audio ref="audioPlayer24" controls autoplay class="video">
          <source v-if="controlNumber === 24" src="../MyComponents/assets/Preparation/audio/24.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===25" class="box-div">
        <img src="../MyComponents/assets/Preparation/image/25.png" alt="img">

        <audio ref="audioPlayer25" controls autoplay class="video">
          <source v-if="controlNumber === 25" src="../MyComponents/assets/Preparation/audio/25.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===26" class="box-div">
        <img src="../MyComponents/assets/Preparation/image/26单选题.png" alt="img">

        <audio ref="audioPlayer26" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===27" class="box-div">
        <img src="../MyComponents/assets/Preparation/image/27.png" alt="img">

        <audio ref="audioPlayer27" controls autoplay class="video">
          <source v-if="controlNumber === 27" src="../MyComponents/assets/Preparation/audio/27.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===28" class="box-div">
        <img src="../MyComponents/assets/Preparation/image/28填空.png" alt="img">

        <audio ref="audioPlayer28" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===29" class="box-div">
        <img src="../MyComponents/assets/Preparation/image/29.png" alt="img">

        <audio ref="audioPlayer29" controls autoplay class="video">
          <source v-if="controlNumber === 29" src="../MyComponents/assets/Preparation/audio/29.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===30" class="box-div">
        <img src="../MyComponents/assets/Preparation/image/30填空.png" alt="img">

        <audio ref="audioPlayer30" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===31" class="box-div">
        <img src="../MyComponents/assets/Preparation/image/31.png" alt="img">

        <audio ref="audioPlayer31" controls autoplay class="video">
          <source v-if="controlNumber === 31" src="../MyComponents/assets/Preparation/audio/31.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===32" class="box-div">
        <img src="../MyComponents/assets/Preparation/image/32选择题.png" alt="img">

        <audio ref="audioPlayer32" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="controlNumber ===33" class="box-div">
        <img src="../MyComponents/assets/Preparation/image/33.png" alt="img">

        <audio ref="audioPlayer33" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

    </div>

    <!--随机处理-->
    <div>
<!--      随机是good-->
      <div v-show="controlNumber===34&&randomString ==='randomGood'&&friendsing===1" class="box-div">
        <img src="../MyComponents/assets/Decide/image/good.png" alt="img">

        <audio ref="audioPlayerrandomGood" controls autoplay class="video">
          <source v-if="randomString === 'randomGood'" src="../MyComponents/assets/Decide/audio/good.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

<!--      随机是bad-->
      <div v-show="controlNumber===34&&randomString ==='randomBad'&&worksing===1" class="box-div">
        <img src="../MyComponents/assets/Decide/image/bad.png" alt="img">

        <audio ref="audioPlayerrandomBad" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <!--争取是否合作-->
      <div v-show="controlNumber===34&&workString ==='workQuestion'&&worksing===2" class="box-div">
        <img src="../MyComponents/assets/Decide/image/question.png" alt="img">

        <div class="fillQuestion">
          汪总思索片刻，便委婉地拒绝了MM公司的收购请求。接下来可以选择结束沟通，或继续争取合作，请选择：
          <button @click="">谈判结束</button>

          <button @click="changeRandomString">谈判继续</button>
        </div>

        <audio ref="audioPlayerworkQuestion" controls autoplay class="video">
          Your browser does not support the audio element.
        </audio>
      </div>

    <!--争取合作-->
      <div v-show="controlNumber===34&&workString ==='goodWork'" class="box-div">
        <img src="../MyComponents/assets/Decide/image/work.png" alt="img">

        <audio ref="audioPlayergoodWork" controls autoplay class="video">
          <source v-if="workString === 'goodWork'" src="../MyComponents/assets/Decide/audio/work.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

    <!--出价-->
      <div v-show="controlNumber===34&&workString ==='talkPrice'" class="box-div">
        <img src="../MyComponents/assets/Decide/image/question.png" alt="img">

        <div class="fillQuestion">
          杨总与之进一步交谈，想以高价吸引对方，进而争取对方的合作， 说到：“我们是真心实意想收购，咱再谈谈。这样，为了表示出我们的诚意，
          MM公司愿意出以初始价格每股<input type="text" placeholder="请输入" @keydown.enter="getEnterContain"></input>元进行这次收购”。

        </div>

        <audio ref="audioPlayerworkQuestion" controls autoplay class="video">
          Your browser does not support the audio element.
        </audio>
      </div>

    </div>

    <!--善意并购-->
    <div>
      <div v-show="friendNumber ===1 &&friendsing===2" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/1.png" alt="img">

        <audio ref="friendNumber1" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===2" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/2.png" alt="img">

        <audio ref="friendNumber2" controls autoplay class="video">
          <source v-if="friendNumber === 2" src="../MyComponents/assets/FriendlyMerge/audio/2.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===3" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/3.png" alt="img">

        <audio ref="friendNumber3" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===4" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/4.png" alt="img">

        <audio ref="friendNumber4" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===5" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/5.png" alt="img">

        <audio ref="friendNumber5" controls autoplay class="video">
          <source v-if="friendNumber === 5" src="../MyComponents/assets/FriendlyMerge/audio/5.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===6" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/6.png" alt="img">

        <audio ref="friendNumber6" controls autoplay class="video">
          <source v-if="friendNumber === 6" src="../MyComponents/assets/FriendlyMerge/audio/6.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===7" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/7.png" alt="img">

        <audio ref="friendNumber7" controls autoplay class="video">
          <source v-if="friendNumber === 7" src="../MyComponents/assets/FriendlyMerge/audio/7.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===8" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/8.png" alt="img">

        <audio ref="friendNumber8" controls autoplay class="video">
          <source v-if="friendNumber === 8" src="../MyComponents/assets/FriendlyMerge/audio/8.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===9" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/9.png" alt="img">

        <audio ref="friendNumber9" controls autoplay class="video">
          <source v-if="friendNumber === 9" src="../MyComponents/assets/FriendlyMerge/audio/9.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===10" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/10.png" alt="img">

        <audio ref="friendNumber10" controls autoplay class="video">
          <source v-if="friendNumber === 10" src="../MyComponents/assets/FriendlyMerge/audio/10.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===11" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/11.png" alt="img">

        <audio ref="friendNumber11" controls autoplay class="video">
          <source v-if="friendNumber === 11" src="../MyComponents/assets/FriendlyMerge/audio/11.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===12" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/12.png" alt="img">

        <audio ref="friendNumber12" controls autoplay class="video">
          <source v-if="friendNumber === 12" src="../MyComponents/assets/FriendlyMerge/audio/12.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===13" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/13.png" alt="img">

        <audio ref="friendNumber13" controls autoplay class="video">
          <source v-if="friendNumber === 13" src="../MyComponents/assets/FriendlyMerge/audio/13.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===14" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/14.png" alt="img">

        <audio ref="friendNumber14" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===15" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/15填空.png" alt="img">

        <audio ref="friendNumber15" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===16" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/16.png" alt="img">

        <audio ref="friendNumber16" controls autoplay class="video">
          <source v-if="friendNumber === 16" src="../MyComponents/assets/FriendlyMerge/audio/16.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===17" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/17.png" alt="img">

        <audio ref="friendNumber17" controls autoplay class="video">
          <source v-if="friendNumber === 17" src="../MyComponents/assets/FriendlyMerge/audio/17.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>


      <div v-show="friendNumber ===18" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/18选择.png" alt="img">

        <audio ref="friendNumber18" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===19" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/19.png" alt="img">

        <audio ref="friendNumber19" controls autoplay class="video">
          <source v-if="friendNumber === 19" src="../MyComponents/assets/FriendlyMerge/audio/19.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===20" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/20选择.png" alt="img">

        <audio ref="friendNumber20" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===21" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/21.png" alt="img">

        <audio ref="friendNumber21" controls autoplay class="video">
          <source v-if="friendNumber === 21" src="../MyComponents/assets/FriendlyMerge/audio/21.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===22" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/22.png" alt="img">

        <audio ref="friendNumber22" controls autoplay class="video">
          <source v-if="friendNumber === 22" src="../MyComponents/assets/FriendlyMerge/audio/22.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===23" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/23.png" alt="img">

        <audio ref="friendNumber23" controls autoplay class="video">
          <source v-if="friendNumber === 23" src="../MyComponents/assets/FriendlyMerge/audio/23.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===24" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/24.png" alt="img">

        <audio ref="friendNumber24" controls autoplay class="video">
          <source v-if="friendNumber === 24" src="../MyComponents/assets/FriendlyMerge/audio/24.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===25" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/25选择.png" alt="img">

        <audio ref="friendNumber25" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===26" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/26.png" alt="img">

        <audio ref="friendNumber26" controls autoplay class="video">
          <source v-if="friendNumber === 26" src="../MyComponents/assets/FriendlyMerge/audio/26.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===27" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/27填空.png" alt="img">

        <audio ref="friendNumber27" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===28" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/28.png" alt="img">

        <audio ref="friendNumber28" controls autoplay class="video">
          <source v-if="friendNumber === 28" src="../MyComponents/assets/FriendlyMerge/audio/28.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===29" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/29.png" alt="img">

        <audio ref="friendNumber29" controls autoplay class="video">
          <source v-if="friendNumber === 29" src="../MyComponents/assets/FriendlyMerge/audio/29.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===30" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/30.png" alt="img">

        <audio ref="friendNumber30" controls autoplay class="video">
          <source v-if="friendNumber === 30" src="../MyComponents/assets/FriendlyMerge/audio/30.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===31" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/31.png" alt="img">

        <audio ref="friendNumber31" controls autoplay class="video">
          <source v-if="friendNumber === 31" src="../MyComponents/assets/FriendlyMerge/audio/31.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

<!--      确定并购主体-->
      <div v-show="friendNumber ===32" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/32选择.png" alt="img">

        <div>
          <button @click="choiceBodyA">A、MM公司</button>
          <button @click="choiceBodyB">B、MM公司控股股东成立的子公司</button>
          <button @click="choiceBodyC">C、与投资公司合作的投资基金</button>
        </div>

        <audio ref="friendNumber32" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===33" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/33.png" alt="img">

        <audio ref="friendNumber33" controls autoplay class="video">
          <source v-if="friendNumber === 33" src="../MyComponents/assets/FriendlyMerge/audio/33.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===34" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/34填空.png" alt="img">

        <audio ref="friendNumber34" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

    </div>
  </div>

    <!--善意并购-->

    <!--善意并购MM公司为主体-->
  <div>
    <!--确定支付方式-->
    <div>
      <div v-show="friendNumber ===35 && FriendBodyString==='F_MM'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/35MM.png" alt="img">

        <audio ref="friendNumber35" controls autoplay class="video">
          <source v-if="friendNumber === 35 && FriendBodyString==='F_MM'" src="../MyComponents/assets/FriendlyMerge/audio/35MM&Son.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===36 && FriendBodyString==='F_MM'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/36MM.png" alt="img">

        <audio ref="friendNumber36" controls autoplay class="video">
          <source v-if="friendNumber === 36 && FriendBodyString==='F_MM'" src="../MyComponents/assets/FriendlyMerge/audio/36MM&Son.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===37&& FriendBodyString==='F_MM'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/37MM.png" alt="img">

        <audio ref="friendNumber37" controls autoplay class="video">
          <source v-if="friendNumber === 37&& FriendBodyString==='F_MM'" src="../MyComponents/assets/FriendlyMerge/audio/37MM&Son.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <!--确定支付方式-->
      <div v-show="friendNumber ===38 && FriendBodyString==='F_MM'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/38支付方式.png" alt="img">

        <div>
          项目组长张总监说到：“大家说的都很有道理，但是我们公司现在拥有货币资金近110亿，并且不同于其他上市公司，MM公司高层并不持有自己公司的股票。我们还是应该采取（）的付款方式。”
          <button @click="choicePayWayA">A、现金支付</button>
          <button @click="choicePayWayB">B、混合支付</button>
        </div>

        <audio ref="friendNumber38" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

    </div>

    <!--善意并购MM公司为主体现金支付-->
    <div>
      <div v-show="friendNumber ===39&& FriendBodyString==='F_MM' &&PayWay==='Cash'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/39现金支付.png" alt="img">

        <audio ref="friendNumber39" controls autoplay class="video">
          <source v-if="friendNumber === 39&& FriendBodyString==='F_MM' &&PayWay==='Cash'" src="../MyComponents/assets/FriendlyMerge/audio/39现金.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <!--此处是现金的多选题-->
      <div v-show="friendNumber ===40&& FriendBodyString==='F_MM' &&PayWay==='Cash'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/40多选题(现金和混合不同）.png" alt="img">

        <div>
          董事会决定，并购采用现金支付的方式。张总监对董事进行汇报时说到：
          “公司MM目前的总资产为658.7亿元，总负债为280.6亿元， 公司的财务政策要求资产负债率不得超过60%，并且公司MM有着良好的银企关系。
          考虑到购买溢价，要想完成收购，需要近180亿的资金，而MM公司现有110亿的资金，日常约束性现金余额为50亿， 因此，需要进行大约120亿元的外部融资。
          我们并购组认为选择的融资方式最好是（）。”（多选题）
        </div>

        <div>
          <label><input type="checkbox">A、股票融资</label>
          <label><input type="checkbox">B、股票融资+债券融资</label>
          <label><input type="checkbox">C、股票融资+银行贷款</label>
        </div>

        <audio ref="friendNumber40" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

    </div>

    <!--善意并购MM公司为主体混合支付-->
    <div>
      <div v-show="friendNumber ===39&& FriendBodyString==='F_MM' &&PayWay==='Mix'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/39混合支付.png" alt="img">

        <audio ref="friendNumber39" controls autoplay class="video">
          <source v-if="friendNumber === 39&& FriendBodyString==='F_MM' &&PayWay==='Mix'" src="../MyComponents/assets/FriendlyMerge/audio/39混合.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <!--此处是现金的多选题-->
      <div v-show="friendNumber ===40&& FriendBodyString==='F_MM' &&PayWay==='Mix'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/40多选题(现金和混合不同）.png" alt="img">

        <div>
          根据以上情况，我们公司可以选择的支付方式是（）。（多选题）
        </div>

        <div>
          <label><input type="checkbox">A、对WW公司原股东定向增发+自有现金</label>
          <label><input type="checkbox">B、对WW公司原股东定向增发+债券融资所获现金</label>
          <label><input type="checkbox">C、对WW公司原股东定向增发+自有现金+银行贷款所获现金</label>
        </div>

        <audio ref="friendNumber40" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

    </div>

    <!--善意并购现金和混合共用资源-->
    <div>
      <div v-show="friendNumber ===41&& FriendBodyString==='F_MM'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/41.png" alt="img">

        <audio ref="friendNumber41" controls autoplay class="video">
          <source v-if="friendNumber === 41&& FriendBodyString==='F_MM'" src="../MyComponents/assets/FriendlyMerge/audio/41.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===42&& FriendBodyString==='F_MM'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/42.png" alt="img">

        <audio ref="friendNumber42" controls autoplay class="video">
          <source v-if="friendNumber === 42&& FriendBodyString==='F_MM'" src="../MyComponents/assets/FriendlyMerge/audio/42.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===43&& FriendBodyString==='F_MM'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/43.png" alt="img">

        <audio ref="friendNumber43" controls autoplay class="video">
          <source v-if="friendNumber === 43&& FriendBodyString==='F_MM'" src="../MyComponents/assets/FriendlyMerge/audio/43.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===44&& FriendBodyString==='F_MM'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/44.png" alt="img">

        <audio ref="friendNumber44" controls autoplay class="video">
          <source v-if="friendNumber === 44&& FriendBodyString==='F_MM'" src="../MyComponents/assets/FriendlyMerge/audio/44.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===45&& FriendBodyString==='F_MM'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/45.png" alt="img">

        <audio ref="friendNumber45" controls autoplay class="video">
          <source v-if="friendNumber === 45&& FriendBodyString==='F_MM'" src="../MyComponents/assets/FriendlyMerge/audio/45.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===46&& FriendBodyString==='F_MM'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/46.png" alt="img">

        <audio ref="friendNumber46" controls autoplay class="video">
          <source v-if="friendNumber === 46&& FriendBodyString==='F_MM'" src="../MyComponents/assets/FriendlyMerge/audio/46.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===47&& FriendBodyString==='F_MM'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/47单选.png" alt="img">

        <audio ref="friendNumber47" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===48&& FriendBodyString==='F_MM'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/48.png" alt="img">

        <audio ref="friendNumber48" controls autoplay class="video">
          <source v-if="friendNumber === 48&& FriendBodyString==='F_MM'" src="../MyComponents/assets/FriendlyMerge/audio/48.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===49&& FriendBodyString==='F_MM'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/49.png" alt="img">

        <audio ref="friendNumber49" controls autoplay class="video">
          <source v-if="friendNumber === 49&& FriendBodyString==='F_MM'" src="../MyComponents/assets/FriendlyMerge/audio/49.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===50&& FriendBodyString==='F_MM'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/50.png" alt="img">

        <audio ref="friendNumber50" controls autoplay class="video">
          <source v-if="friendNumber === 50&& FriendBodyString==='F_MM'" src="../MyComponents/assets/FriendlyMerge/audio/50.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===51&& FriendBodyString==='F_MM'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/51.png" alt="img">

        <audio ref="friendNumber51" controls autoplay class="video">
          <source v-if="friendNumber === 51&& FriendBodyString==='F_MM'" src="../MyComponents/assets/FriendlyMerge/audio/51.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===52&& FriendBodyString==='F_MM'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/52.png" alt="img">

        <audio ref="friendNumber52" controls autoplay class="video">
          <source v-if="friendNumber === 52&& FriendBodyString==='F_MM'" src="../MyComponents/assets/FriendlyMerge/audio/52.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===53&& FriendBodyString==='F_MM'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/53.png" alt="img">

        <audio ref="friendNumber53" controls autoplay class="video">
          <source v-if="friendNumber === 53&& FriendBodyString==='F_MM'" src="../MyComponents/assets/FriendlyMerge/audio/53.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===54&& FriendBodyString==='F_MM'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/54.png" alt="img">

        <audio ref="friendNumber54" controls autoplay class="video">
          <source v-if="friendNumber === 54&& FriendBodyString==='F_MM'" src="../MyComponents/assets/FriendlyMerge/audio/54.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===55&& FriendBodyString==='F_MM'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/55.png" alt="img">

        <audio ref="friendNumber55" controls autoplay class="video">
          <source v-if="friendNumber === 55&& FriendBodyString==='F_MM'" src="../MyComponents/assets/FriendlyMerge/audio/55.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===56&& FriendBodyString==='F_MM'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/56.png" alt="img">

        <audio ref="friendNumber56" controls autoplay class="video">
          <source v-if="friendNumber === 56&& FriendBodyString==='F_MM'" src="../MyComponents/assets/FriendlyMerge/audio/56.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===57&& FriendBodyString==='F_MM'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/57简答.png" alt="img">

        <audio ref="friendNumber57" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===58&& FriendBodyString==='F_MM'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/58.png" alt="img">

        <audio ref="friendNumber58" controls autoplay class="video">
          <source v-if="friendNumber === 58&& FriendBodyString==='F_MM'" src="../MyComponents/assets/FriendlyMerge/audio/58.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===59&& FriendBodyString==='F_MM'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/59填空.png" alt="img">

        <audio ref="friendNumber59" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===60&& FriendBodyString==='F_MM'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/60并购完成.png" alt="img">

        <audio ref="friendNumber60" controls autoplay class="video">
          <source v-if="friendNumber === 60&& FriendBodyString==='F_MM'" src="../MyComponents/assets/FriendlyMerge/audio/60.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

    </div>

    <!--善意并购MM报告-->
    <div>
      <!--现金结果-->
      <div v-show="friendNumber ===61&& FriendBodyString==='F_MM'&&PayWay==='Cash'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/MM现金.png" alt="img">

        <audio ref="friendNumber61" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <!--混合结果-->
      <div v-show="friendNumber ===61&& FriendBodyString==='F_MM' &&PayWay==='Mix'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/MM混合.png" alt="img">

        <audio ref="friendNumber61" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

    </div>

  </div>

    <!--善意并购子公司为主体-->
  <div>
    <!--确定支付方式-->
      <div>
        <div>
          <div v-show="friendNumber ===35 && FriendBodyString==='F_Son'" class="box-div">
            <img src="../MyComponents/assets/FriendlyMerge/image/35Son.png" alt="img">

            <audio ref="friendNumber35" controls autoplay class="video">
              <source v-if="friendNumber === 35 && FriendBodyString==='F_Son'" src="../MyComponents/assets/FriendlyMerge/audio/35MM&Son.mp3" type="audio/mpeg">
              Your browser does not support the audio element.
            </audio>
          </div>
        </div>

        <div>
          <div v-show="friendNumber ===36 && FriendBodyString==='F_Son'" class="box-div">
            <img src="../MyComponents/assets/FriendlyMerge/image/36Son.png" alt="img">

            <audio ref="friendNumber36" controls autoplay class="video">
              <source v-if="friendNumber === 36 && FriendBodyString==='F_Son'" src="../MyComponents/assets/FriendlyMerge/audio/36MM&Son.mp3" type="audio/mpeg">
              Your browser does not support the audio element.
            </audio>
          </div>
        </div>

        <div>
          <div v-show="friendNumber ===37 && FriendBodyString==='F_Son'" class="box-div">
            <img src="../MyComponents/assets/FriendlyMerge/image/37Son.png" alt="img">

            <audio ref="friendNumber37" controls autoplay class="video">
              <source v-if="friendNumber === 37 && FriendBodyString==='F_Son'" src="../MyComponents/assets/FriendlyMerge/audio/37MM&Son.mp3" type="audio/mpeg">
              Your browser does not support the audio element.
            </audio>
          </div>
        </div>

        <!--确定支付方式-->
        <div v-show="friendNumber ===38 && FriendBodyString==='F_Son'" class="box-div">
          <img src="../MyComponents/assets/FriendlyMerge/image/38支付方式.png" alt="img">

          <div>
            项目组长张总监说到：“大家说的都很有道理，但是我们公司现在拥有货币资金近110亿，并且不同于其他上市公司，MM公司高层并不持有自己公司的股票。我们还是应该采取（）的付款方式。”
            <button @click="choicePayWayA">A、现金支付</button>
            <button @click="choicePayWayB">B、混合支付</button>
          </div>

          <audio ref="friendNumber38" controls autoplay class="video">

            Your browser does not support the audio element.
          </audio>
        </div>
      </div>

    <!--善意并购子公司为主体现金支付-->
      <div>
        <div v-show="friendNumber ===39&& FriendBodyString==='F_Son' &&PayWay==='Cash'" class="box-div">
          <img src="../MyComponents/assets/FriendlyMerge/image/39现金支付.png" alt="img">

          <audio ref="friendNumber39" controls autoplay class="video">
            <source v-if="friendNumber === 39&& FriendBodyString==='F_Son' &&PayWay==='Cash'" src="../MyComponents/assets/FriendlyMerge/audio/39现金.mp3" type="audio/mpeg">
            Your browser does not support the audio element.
          </audio>
        </div>

        <!--此处是现金的多选题-->
        <div v-show="friendNumber ===40&& FriendBodyString==='F_Son' &&PayWay==='Cash'" class="box-div">
          <img src="../MyComponents/assets/FriendlyMerge/image/40多选题(现金和混合不同）.png" alt="img">

          <div>
            董事会决定，并购采用现金支付的方式。张总监对董事进行汇报时说到：
            “公司MM目前的总资产为658.7亿元，总负债为280.6亿元， 公司的财务政策要求资产负债率不得超过60%，并且公司MM有着良好的银企关系。
            考虑到购买溢价，要想完成收购，需要近180亿的资金，而MM公司现有110亿的资金，日常约束性现金余额为50亿， 因此，需要进行大约120亿元的外部融资。
            我们并购组认为选择的融资方式最好是（）。”（多选题）
          </div>

          <div>
            <label><input type="checkbox">A、股票融资</label>
            <label><input type="checkbox">B、股票融资+债券融资</label>
            <label><input type="checkbox">C、股票融资+银行贷款</label>
          </div>

          <audio ref="friendNumber40" controls autoplay class="video">

            Your browser does not support the audio element.
          </audio>
        </div>

      </div>

    <!--善意并购子公司为主体混合支付-->
      <div>
        <div v-show="friendNumber ===39&& FriendBodyString==='F_Son' &&PayWay==='Mix'" class="box-div">
          <img src="../MyComponents/assets/FriendlyMerge/image/39混合支付.png" alt="img">

          <audio ref="friendNumber39" controls autoplay class="video">
            <source v-if="friendNumber === 39&& FriendBodyString==='F_Son' &&PayWay==='Mix'" src="../MyComponents/assets/FriendlyMerge/audio/39混合.mp3" type="audio/mpeg">
            Your browser does not support the audio element.
          </audio>
        </div>

        <!--此处是现金的多选题-->
        <div v-show="friendNumber ===40&& FriendBodyString==='F_Son' &&PayWay==='Mix'" class="box-div">
          <img src="../MyComponents/assets/FriendlyMerge/image/40多选题(现金和混合不同）.png" alt="img">

          <div>
            根据以上情况，我们公司可以选择的支付方式是（）。（多选题）
          </div>

          <div>
            <label><input type="checkbox">A、对WW公司原股东定向增发+自有现金</label>
            <label><input type="checkbox">B、对WW公司原股东定向增发+债券融资所获现金</label>
            <label><input type="checkbox">C、对WW公司原股东定向增发+自有现金+银行贷款所获现金</label>
          </div>

          <audio ref="friendNumber40" controls autoplay class="video">

            Your browser does not support the audio element.
          </audio>
        </div>

      </div>

    <!--善意并购现金和混合共用资源-->
      <div>
      <div v-show="friendNumber ===41&& FriendBodyString==='F_Son'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/41.png" alt="img">

        <audio ref="friendNumber41" controls autoplay class="video">
          <source v-if="friendNumber === 41&& FriendBodyString==='F_Son'" src="../MyComponents/assets/FriendlyMerge/audio/41.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===42&& FriendBodyString==='F_Son'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/42.png" alt="img">

        <audio ref="friendNumber42" controls autoplay class="video">
          <source v-if="friendNumber === 42&& FriendBodyString==='F_Son'" src="../MyComponents/assets/FriendlyMerge/audio/42.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===43&& FriendBodyString==='F_Son'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/43.png" alt="img">

        <audio ref="friendNumber43" controls autoplay class="video">
          <source v-if="friendNumber === 43&& FriendBodyString==='F_Son'" src="../MyComponents/assets/FriendlyMerge/audio/43.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===44&& FriendBodyString==='F_Son'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/44.png" alt="img">

        <audio ref="friendNumber44" controls autoplay class="video">
          <source v-if="friendNumber === 44&& FriendBodyString==='F_Son'" src="../MyComponents/assets/FriendlyMerge/audio/44.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===45&& FriendBodyString==='F_Son'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/45.png" alt="img">

        <audio ref="friendNumber45" controls autoplay class="video">
          <source v-if="friendNumber === 45&& FriendBodyString==='F_Son'" src="../MyComponents/assets/FriendlyMerge/audio/45.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===46&& FriendBodyString==='F_Son'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/46.png" alt="img">

        <audio ref="friendNumber46" controls autoplay class="video">
          <source v-if="friendNumber === 46&& FriendBodyString==='F_Son'" src="../MyComponents/assets/FriendlyMerge/audio/46.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===47&& FriendBodyString==='F_Son'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/47单选.png" alt="img">

        <audio ref="friendNumber47" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===48&& FriendBodyString==='F_Son'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/48.png" alt="img">

        <audio ref="friendNumber48" controls autoplay class="video">
          <source v-if="friendNumber === 48&& FriendBodyString==='F_Son'" src="../MyComponents/assets/FriendlyMerge/audio/48.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===49&& FriendBodyString==='F_Son'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/49.png" alt="img">

        <audio ref="friendNumber49" controls autoplay class="video">
          <source v-if="friendNumber === 49&& FriendBodyString==='F_Son'" src="../MyComponents/assets/FriendlyMerge/audio/49.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===50&& FriendBodyString==='F_Son'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/50.png" alt="img">

        <audio ref="friendNumber50" controls autoplay class="video">
          <source v-if="friendNumber === 50&& FriendBodyString==='F_Son'" src="../MyComponents/assets/FriendlyMerge/audio/50.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===51&& FriendBodyString==='F_Son'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/51.png" alt="img">

        <audio ref="friendNumber51" controls autoplay class="video">
          <source v-if="friendNumber === 51&& FriendBodyString==='F_Son'" src="../MyComponents/assets/FriendlyMerge/audio/51.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===52&& FriendBodyString==='F_Son'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/52.png" alt="img">

        <audio ref="friendNumber52" controls autoplay class="video">
          <source v-if="friendNumber === 52&& FriendBodyString==='F_Son'" src="../MyComponents/assets/FriendlyMerge/audio/52.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===53&& FriendBodyString==='F_Son'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/53.png" alt="img">

        <audio ref="friendNumber53" controls autoplay class="video">
          <source v-if="friendNumber === 53&& FriendBodyString==='F_Son'" src="../MyComponents/assets/FriendlyMerge/audio/53.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===54&& FriendBodyString==='F_Son'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/54.png" alt="img">

        <audio ref="friendNumber54" controls autoplay class="video">
          <source v-if="friendNumber === 54&& FriendBodyString==='F_Son'" src="../MyComponents/assets/FriendlyMerge/audio/54.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===55&& FriendBodyString==='F_Son'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/55.png" alt="img">

        <audio ref="friendNumber55" controls autoplay class="video">
          <source v-if="friendNumber === 55&& FriendBodyString==='F_Son'" src="../MyComponents/assets/FriendlyMerge/audio/55.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===56&& FriendBodyString==='F_Son'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/56.png" alt="img">

        <audio ref="friendNumber56" controls autoplay class="video">
          <source v-if="friendNumber === 56&& FriendBodyString==='F_Son'" src="../MyComponents/assets/FriendlyMerge/audio/56.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===57&& FriendBodyString==='F_Son'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/57简答.png" alt="img">

        <audio ref="friendNumber57" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===58&& FriendBodyString==='F_Son'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/58.png" alt="img">

        <audio ref="friendNumber58" controls autoplay class="video">
          <source v-if="friendNumber === 58&& FriendBodyString==='F_Son'" src="../MyComponents/assets/FriendlyMerge/audio/58.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===59&& FriendBodyString==='F_Son'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/59填空.png" alt="img">

        <audio ref="friendNumber59" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===60&& FriendBodyString==='F_Son'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/60并购完成.png" alt="img">

        <audio ref="friendNumber60" controls autoplay class="video">
          <source v-if="friendNumber === 60&& FriendBodyString==='F_Son'" src="../MyComponents/assets/FriendlyMerge/audio/60.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <!--混合并购回归母公司-->
      <div v-show="friendNumber ===61&& FriendBodyString==='F_Son'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/回归母公司.png" alt="img">

        <audio ref="friendNumber61" controls autoplay class="video">
          <source v-if="friendNumber === 61&& FriendBodyString==='F_Son'" src="../MyComponents/assets/FriendlyMerge/audio/回归母公司.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

    </div>

    <!--善意并购子公司报告-->
    <div>
      <!--现金结果-->
      <div v-show="friendNumber ===62&& FriendBodyString==='F_Son'&&PayWay==='Cash'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/Son现金.png" alt="img">

        <audio ref="friendNumber62" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <!--混合结果-->
      <div v-show="friendNumber ===62&& FriendBodyString==='F_SOn' &&PayWay==='Mix'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/Son混合.png" alt="img">

        <audio ref="friendNumber62" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

    </div>

  </div>

    <!--善意并购投资基金为主体-->
  <div>

    <div v-show="friendNumber ===35 && FriendBodyString ==='F_Gold' " class="box-div">
      <img src="../MyComponents/assets/FriendlyMerge/image/35Gold.png" alt="img">

      <audio ref="friendNumber35" controls autoplay class="video">
        <source v-if="friendNumber === 35" src="../MyComponents/assets/FriendlyMerge/audio/35Gold.mp3" type="audio/mpeg">
        Your browser does not support the audio element.
      </audio>
    </div>

    <div v-show="friendNumber ===36&& FriendBodyString==='F_Gold' &&PayWay==='Mix'" class="box-div">
      <img src="../MyComponents/assets/FriendlyMerge/image/40多选题(现金和混合不同）.png" alt="img">

      <div>
        根据以上情况，我们公司可以选择的支付方式是（）。（多选题）
      </div>

      <div>
        <label><input type="checkbox">A、对WW公司原股东定向增发+自有现金</label>
        <label><input type="checkbox">B、对WW公司原股东定向增发+债券融资所获现金</label>
        <label><input type="checkbox">C、对WW公司原股东定向增发+自有现金+银行贷款所获现金</label>
      </div>

      <audio ref="friendNumber36" controls autoplay class="video">

        Your browser does not support the audio element.
      </audio>
    </div>

    <!--共用资源但是Gold标识不一样，只是在number上不一样-->
    <div>
      <div v-show="friendNumber ===37&& FriendBodyString==='F_Gold'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/41.png" alt="img">

        <audio ref="friendNumber37" controls autoplay class="video">
          <source v-if="friendNumber === 37&& FriendBodyString==='F_Gold'" src="../MyComponents/assets/FriendlyMerge/audio/41.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===38&& FriendBodyString==='F_Gold'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/42.png" alt="img">

        <audio ref="friendNumber38" controls autoplay class="video">
          <source v-if="friendNumber === 38&& FriendBodyString==='F_Gold'" src="../MyComponents/assets/FriendlyMerge/audio/42.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===39&& FriendBodyString==='F_Gold'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/43.png" alt="img">

        <audio ref="friendNumber39" controls autoplay class="video">
          <source v-if="friendNumber === 39&& FriendBodyString==='F_Gold'" src="../MyComponents/assets/FriendlyMerge/audio/43.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===40&& FriendBodyString==='F_Gold'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/44.png" alt="img">

        <audio ref="friendNumber40" controls autoplay class="video">
          <source v-if="friendNumber === 40&& FriendBodyString==='F_Gold'" src="../MyComponents/assets/FriendlyMerge/audio/44.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===41&& FriendBodyString==='F_Gold'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/45.png" alt="img">

        <audio ref="friendNumber41" controls autoplay class="video">
          <source v-if="friendNumber === 41&& FriendBodyString==='F_Gold'" src="../MyComponents/assets/FriendlyMerge/audio/45.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===42&& FriendBodyString==='F_Gold'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/46.png" alt="img">

        <audio ref="friendNumber42" controls autoplay class="video">
          <source v-if="friendNumber === 42&& FriendBodyString==='F_Gold'" src="../MyComponents/assets/FriendlyMerge/audio/46.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===43&& FriendBodyString==='F_Gold'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/47单选.png" alt="img">

        <audio ref="friendNumber43" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===44&& FriendBodyString==='F_Gold'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/48.png" alt="img">

        <audio ref="friendNumber44" controls autoplay class="video">
          <source v-if="friendNumber === 44&& FriendBodyString==='F_Gold'" src="../MyComponents/assets/FriendlyMerge/audio/48.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===45&& FriendBodyString==='F_Gold'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/49.png" alt="img">

        <audio ref="friendNumber45" controls autoplay class="video">
          <source v-if="friendNumber === 45&& FriendBodyString==='F_Gold'" src="../MyComponents/assets/FriendlyMerge/audio/49.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===46&& FriendBodyString==='F_Gold'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/50.png" alt="img">

        <audio ref="friendNumber46" controls autoplay class="video">
          <source v-if="friendNumber === 46&& FriendBodyString==='F_Gold'" src="../MyComponents/assets/FriendlyMerge/audio/50.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===47&& FriendBodyString==='F_Gold'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/51.png" alt="img">

        <audio ref="friendNumber47" controls autoplay class="video">
          <source v-if="friendNumber === 47&& FriendBodyString==='F_Gold'" src="../MyComponents/assets/FriendlyMerge/audio/51.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===48&& FriendBodyString==='F_Gold'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/52.png" alt="img">

        <audio ref="friendNumber48" controls autoplay class="video">
          <source v-if="friendNumber === 48&& FriendBodyString==='F_Gold'" src="../MyComponents/assets/FriendlyMerge/audio/52.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===49&& FriendBodyString==='F_Gold'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/53.png" alt="img">

        <audio ref="friendNumber49" controls autoplay class="video">
          <source v-if="friendNumber === 49&& FriendBodyString==='F_Gold'" src="../MyComponents/assets/FriendlyMerge/audio/53.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===50&& FriendBodyString==='F_Gold'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/54.png" alt="img">

        <audio ref="friendNumber50" controls autoplay class="video">
          <source v-if="friendNumber === 50&& FriendBodyString==='F_Gold'" src="../MyComponents/assets/FriendlyMerge/audio/54.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===51&& FriendBodyString==='F_Gold'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/55.png" alt="img">

        <audio ref="friendNumber51" controls autoplay class="video">
          <source v-if="friendNumber === 51&& FriendBodyString==='F_Gold'" src="../MyComponents/assets/FriendlyMerge/audio/55.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===52&& FriendBodyString==='F_Gold'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/56.png" alt="img">

        <audio ref="friendNumber52" controls autoplay class="video">
          <source v-if="friendNumber === 52&& FriendBodyString==='F_Gold'" src="../MyComponents/assets/FriendlyMerge/audio/56.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===53&& FriendBodyString==='F_Gold'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/57简答.png" alt="img">

        <audio ref="friendNumber53" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===54&& FriendBodyString==='F_Gold'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/58.png" alt="img">

        <audio ref="friendNumber54" controls autoplay class="video">
          <source v-if="friendNumber === 54&& FriendBodyString==='F_Gold'" src="../MyComponents/assets/FriendlyMerge/audio/58.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===55&& FriendBodyString==='F_Gold'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/59填空.png" alt="img">

        <audio ref="friendNumber55" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

      <div v-show="friendNumber ===56&& FriendBodyString==='F_Gold'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/60并购完成.png" alt="img">

        <audio ref="friendNumber56" controls autoplay class="video">
          <source v-if="friendNumber === 56&& FriendBodyString==='F_Gold'" src="../MyComponents/assets/FriendlyMerge/audio/60.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

      <!--混合并购回归母公司-->
      <div v-show="friendNumber ===57&& FriendBodyString==='F_Gold'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/回归母公司.png" alt="img">

        <audio ref="friendNumber57" controls autoplay class="video">
          <source v-if="friendNumber === 57&& FriendBodyString==='F_Gold'" src="../MyComponents/assets/FriendlyMerge/audio/回归母公司.mp3" type="audio/mpeg">
          Your browser does not support the audio element.
        </audio>
      </div>

    <!--投资基金报告-->
      <div v-show="friendNumber ===58&& FriendBodyString==='F_Gold'" class="box-div">
        <img src="../MyComponents/assets/FriendlyMerge/image/gold.png" alt="img">

        <audio ref="friendNumber58" controls autoplay class="video">

          Your browser does not support the audio element.
        </audio>
      </div>

    </div>

  </div>


    <!--恶意并购-->
    <div>

    </div>

    <div class="el-button">
      <el-button @click="toPage32"></el-button>

      <el-button @click="toPageFrinend30"></el-button>
    </div>

    <div @click="changePage">
      <MyButton />
    </div>
  </div>
</template>

<script>
import Schedule from "@/views/Student/ExerciseStart/MyComponents/schedule.vue";
import MyButton from "@/views/Student/ExerciseStart/MyComponents/MyButton.vue";
import axios from "axios";
import MyTest from "@/views/Test/index.vue";

export default {
  name: "imgExe",
  components: {
    MyTest,
    Schedule,
    MyButton
  },
  data(){
    return{
      //控制preparation的number
      controlNumber:1,
      //控制随机生成意向调查的string
      randomString:'',
      //控制是否争取合作的string
      workString:'',
      //善意并购控制的number
      friendNumber:0,

      //善意并购选择主体的string
      FriendBodyString:'',
      /*
      * 善意并购MM公司
      * F_MM:'',
      * 善意并购子公司
      * F_Son:'',
      * 善意并购投资资金
      * F_Gold:'',
      * */

      // 选择支付方式
      PayWay:'',
      /*
      * 现金：Cash
      * 混合：Mix
      * */




      //切换器
      friendsing:0,
      worksing:0,

      isPlaying:true,

    }
  },
  methods:{
    changePage(){
      let audio = ("audioPlayer"+this.controlNumber)
      let audio2 =("friendNumber"+this.friendNumber)
      if(this.controlNumber<=33){
        if (audio){
          this.pauseAudio("audioPlayer"+this.controlNumber)
        }
        this.controlNumber +=1;
      }

      //Math.random();
      //意愿调查中随机生成好和坏两个大方向
        if(this.controlNumber===34 &&this.randomString===''){
          // 生成一个介于 0（包括）和 1（不包括）之间的随机小数
          var randomValue =0.1
          // 判断随机数的值，决定事件发生与否
          if (randomValue < 0.5) {
            this.randomString='randomGood'
          } else {
            this.randomString='randomBad'
          }
        }

      // 当random=randomGood时，进入善意并购
      if(this.randomString==='randomGood') {
        this.friendNumber =1
        this.friendsing+=1
        if (this.friendsing>1){
          this.pauseAudio("audioPlayerrandomGood")
        }
        console.log('in 善意页面 friend number ='+this.friendNumber)
        console.log('in 善意页面 friend sing ='+this.friendsing)
      }



      if(this.friendsing>2) {
        this.randomString='end'

        if (audio2){
          this.pauseAudio("friendNumber"+this.friendNumber)
        }

        this.friendNumber+=1

        //在善意并购中，使用friendSing作为递增判断了，friendSing一直等于3，就像controlNumber一直等于34

        console.log('in 切换页面 friend number ='+this.friendNumber)
        console.log('in 切换页面 friend sing ='+this.friendsing)
      }




      //当random=randomBad时，是否争取合作
      if(this.randomString==='randomBad'){
        this.workString='workQuestion'
        this.worksing +=1
      }

      if(this.worksing>2)
      {
        this.randomString='end'
      }




      //当workSting=goodWork时，谈价格
      if(this.workString==='goodWork'){
        let Workaudio=("audioPlayer"+this.workString)
          this.pauseAudio(Workaudio)
        this.workString='talkPrice'
      }


      console.log("fri number"+this.friendNumber)
      console.log("fri sing"+this.friendsing)
      console.log("ran string"+this.randomString)
    },


    // 其他部分
    pauseAudio(name) {
      const audioPlayer = this.$refs[name];
        audioPlayer.pause();
    },

    changeRandomString(){
      this.randomString='end'
      this.workString='goodWork'
    },

    //善意并购选择并购主体
    choiceBodyA(){
      this.FriendBodyString='F_MM'
    },

    choiceBodyB(){
      this.FriendBodyString='F_Son'
    },

    choiceBodyC(){
      this.FriendBodyString='F_Gold'
      this.PayWay='Mix'
    },

    //选择支付方式
    choicePayWayA(){
      this.PayWay='Cash'
    },

    choicePayWayB(){
      this.PayWay='Mix'
    },



    toPage32(){
      this.controlNumber=33
    },

    toPageFrinend30(){
      this.friendNumber=30
    }

  }
}
</script>

<style scoped >
.box-div{
  width: 100%;
  height: calc(100vh - 69.5px)
}
img{
  width: 100%;
  height: 100%;
  object-fit: fill;
}

.el-button{
  position: absolute;
  left: 20px;
  top: 20px;
}

</style>
