<template>
  <home-layout>
    <div :class="{'landing-page': true,'show-mobile-menu': showMobileMenu}">

      <div class="main-container">
        <div class="landing-page-nav">
          <headroom style="height:initial;">
            <nav>
              <div class="container d-flex align-items-center justify-content-between">
                <a class="navbar-logo pull-left" @click="scrollTo('#home')" href="javascript:;" style="heigth:90px!important;">
                  <img src="@/assets/logos/home.png" style="width:60px; margin-top:15px;" />
                </a>
                <ul class="navbar-nav d-none d-lg-flex flex-row">
                  <li class="nav-item">
                    <a @click="scrollTo('#features')" href="javascript:;">소개</a>
                  </li>
                  <li class="nav-item">
                    <a @click="scrollTo('#layouts')" href="javascript:;">기능</a>
                  </li>
                  <li class="nav-item">
                    <a @click="scrollTo('#components')" href="javascript:;">뮤직DNA</a>
                  </li>
                  <li class="nav-item">
                    <a class="btn btn-primary btn-lg text-light" :href="adminRoot+'/main'">감성DJ 즐기기</a>
                  </li>
                </ul>
                <span
                  class="mobile-menu-button"
                  @click="showMobileMenu=!showMobileMenu; $event.stopPropagation()"
                >
                  <i class="simple-icon-menu"></i>
                </span>
              </div>
            </nav>
          </headroom>
        </div>

        <div class="content-container" id="home">
          <div class="section home" id="sectionHome">
            <div class="container">
              <div class="row home-row" id="homeRow">
                <div class="col-12 d-block d-md-none">
                  <a :href="adminRoot" target="_blank">
                    <video controls>
                      <source src="/assets/img/landing-page/intro.mp4" type="video/mp4">
                    </video>
                  </a>
                </div>

                <div class="col-12 col-xl-4 col-lg-5 col-md-6">
                  <div class="home-text">
                    <div>
                      <h1 style="color:white;">감성 DJ</h1>
                      <h3 style="color:white;">감성으로 받는 추천 플레이리스트</h3>
                    </div>

                    <p class="white mt-5 mb-5">
                      즐거움, 사랑, 슬픔
                      <br />
                      <br />당신의 현재 감성은 무엇인가요?
                      <br />
                      <br />감성에 따라 추천 플레이리스트를 들어보세요
                    </p>

                    <a class="btn btn-light btn-xl mr-2 mb-2" :href="adminRoot+'/main'" target="_blank">
                      시작하기 >
                    </a>
                  </div>
                </div>
                <!-- 이미지 -->
                <div class="col-12 col-xl-7 offset-xl-1 col-lg-7 col-md-6 d-none d-md-block">
                  <a :href="adminRoot">
<!--                    <img alt="hero" src="/assets/img/landing-page/home-hero.png" />-->
                    <video controls>
                      <source src="/assets/img/landing-page/intro.mp4" type="video/mp4">
                    </video>
<!--                    <img class="intro-carousel" src="/assets/img/landing-page/carousel.gif" alt="">-->
                  </a>
                </div>
              </div>


              <div class="row">
                <a
                  class="btn btn-circle btn-outline-semi-light hero-circle-button"
                  @click="scrollTo('#features')"
                  style="margin-left: 80px;"
                >
                  <i class="simple-icon-arrow-down"></i>
                </a>
              </div>
            </div>
          </div>

          <div class="section">
            <div class="container" id="features">
              <div class="row">
                <div class="col-12 offset-0 col-lg-8 offset-lg-2 text-center">
                  <h1>감성에 따라 달라지는 플레이리스트</h1>
                  <p>
                    가사분석을 통해 노래의 감성을 즐거움, 사랑, 슬픔으로 구분하여 감성별 플레이리스트를 들을 수 있습니다.
                  </p>
                </div>
              </div>

              <div v-for="(feature,i) in main" :key="`feature_${i}`">
                <div v-if="i%2==0" class="row feature-row">
                  <div class="col-12 col-md-6 col-lg-5 d-flex align-items-center">
                    <div class="feature-text-container">
                      <h2>{{feature.title}}</h2>
                      <p v-html="feature.detail"></p>
                    </div>
                  </div>
                  <div class="col-12 col-md-6 col-lg-6 offset-lg-1 offset-md-0 position-relative">
                    <img
                      :alt="feature.title"
                      :src="feature.img"
                      class="feature-image-right feature-image-charts position-relative"
                    />
                  </div>
                </div>
                <div v-if="i%2==1" class="row feature-row">
                  <div class="col-12 col-md-6 col-lg-6 order-2 order-md-1">
                    <img
                      :alt="feature.title"
                      :src="feature.img"
                      class="feature-image-left feature-image-charts"
                    />
                  </div>
                  <div
                    class="col-12 col-md-6 offset-md-0 col-lg-5 offset-lg-1 d-flex align-items-center order-1 order-md-2"
                  >
                    <div class="feature-text-container">
                      <h2>{{feature.title}}</h2>
                      <p v-html="feature.detail"></p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="section background">
            <div class="container" id="layouts">
              <div class="row">
                <div class="col-12 offset-0 col-lg-8 offset-lg-2 text-center">
                  <h1>시간 &amp; 날씨에 따른 추천 플레이리스트</h1>
                  <p>
                    시간대와 날씨가 듣고자하는 음악의 감성에 영향을 준다는 사실 알고계셨나요?
                    <br />저희는 시간, 날씨에 따라 음악을 추천해줍니다.
                  </p>
                </div>
              </div>
              <div class="row pt-5">
                <b-card class="col-4">
                  <b-card-title>등교 혹은 출근길, 어떤 음악을 들으시나요?</b-card-title>
                  <DoughnutChart :data="doughnutData[0]" shadow/>
                </b-card>
                <b-card class="col-4">
                  <b-card-title>나른한 1시, 어떤 음악을 들으시나요?</b-card-title>
                  <DoughnutChart :data="doughnutData[1]" shadow/>
                </b-card>
                <b-card class="col-4">
                  <b-card-title>비가 오는 날, 어떤 음악을 들으시나요?</b-card-title>
                  <DoughnutChart :data="doughnutData[2]" shadow/>
                </b-card>
              </div>
              <h4 class="text-left mt-3">시간에 따른 추천</h4>
              <b-row class="pt-1">
                <b-colxx cols="2" v-for="(data, index) in songTime" :key="index" class="pr-3 pl-3 mb-4 glide__slide">
                <div class=" mb-5">
                    <b-card no-body>
                        <div class="position-relative">
                          <img class="card-img-top" :src="data.img" alt="Card cap" />
                        </div>
                        <b-card-body>
                            <h6 class="mb-4 ellipsis">{{ data.name }}</h6>
                            <p class="text-muted mb-0 font-weight-light ellipsis">{{ data.artist[0].name }}</p>
                            <div class="mt-4" style="font-size:x-large;">
                                <span class="glyph-icon simple-icon-control-play mr-3" style="font-size:x-large; cursor:pointer;" ></span>
                                <span :id='data.id' class="glyph-icon simple-icon-heart mr-3" style="cursor:pointer;"></span>
                                <span class="glyph-icon simple-icon-playlist mr-3" style="font-size:x-large; cursor:pointer;" ></span>
                            </div>
                        </b-card-body>
                    </b-card>
                </div>
                </b-colxx>
              </b-row>
              <h4 class="text-left mt-3">날씨에 따른 추천</h4>
              <b-row class="pt-1">
                <b-colxx cols="2" v-for="(data, index) in songWeather" :key="index" class="pr-3 pl-3 mb-4 glide__slide">
                <div class=" mb-5">
                    <b-card no-body>
                        <div class="position-relative">
                          <img class="card-img-top" :src="data.img" alt="Card cap" />
                        </div>
                        <b-card-body>
                            <h6 class="mb-4 ellipsis">{{ data.name }}</h6>
                            <p class="text-muted mb-0 font-weight-light ellipsis">{{ data.artist[0].name }}</p>
                            <div class="mt-4" style="font-size:x-large;">
                                <span class="glyph-icon simple-icon-control-play mr-3" style="font-size:x-large; cursor:pointer;" ></span>
                                <span :id='data.id' class="glyph-icon simple-icon-heart mr-3" style="cursor:pointer;"></span>
                                <span class="glyph-icon simple-icon-playlist mr-3" style="font-size:x-large; cursor:pointer;" ></span>
                            </div>
                        </b-card-body>
                    </b-card>
                </div>
                </b-colxx>
              </b-row>
            </div>
          </div>

          <div class="section mb-0">
            <div class="container" id="components">
              <div class="row mb-5">
                <div class="col-12 offset-0 col-lg-8 offset-lg-2 text-center">
                  <h1>Music DNA</h1>
                  <p>
                    사용자가 듣는 음악의 취향을 분석해줍니다.
                    <br />
                    <br />많은 곡을 들을수록 더 적합한 음악을 추천해 줄 수 있습니다.
                  </p>
                </div>
              </div>
            </div>
            <b-row class="w-85 mx-auto">
              <b-colxx lg="3" xl="3" class="mb-4">
                  <gradient-with-radial-progress-card
                      icon="simple-icon-heart"
                      title="ambience"
                      :detail=favAmbiance
                      :percent=Number(favAmbianceProp.slice(0,favAmbianceProp.length-1))
                      :progressText=favAmbianceProp
                  />
              </b-colxx>
              <b-colxx lg="3" xl="3" class="mb-4">
                  <gradient-with-radial-progress-card
                      icon="simple-icon-star"
                      title="Genre"
                      :detail=favGenre
                      :percent=Number(favGenreProp.slice(0,favGenreProp.length-1))
                      :progressText=favGenreProp
                  />
              </b-colxx>
              <b-colxx lg="3" xl="3" class="mb-4">
                  <gradient-with-radial-progress-card
                      icon="simple-icon-user"
                      title="Artist"
                      :detail=favArtist
                      :percent=Number(favArtistProp.slice(0,favArtistProp.length-1))
                      :progressText=favArtistProp
                  />
              </b-colxx>
              <b-colxx lg="3" xl="3" class="mb-4">
                  <gradient-with-radial-progress-card
                      icon="simple-icon-clock"
                      title="Time"
                      :detail=favTime
                      :percent=Number(favTimeProp.slice(0,favTimeProp.length-1))
                      :progressText=favTimeProp
                  />
              </b-colxx>
            </b-row>
            <div class="w-85 mx-auto">
              <b-card title="시간대별 이용 현황" class="mx-3">
                  <div class="dashboard-line-chart">
                  <line-chart :data="lineChartData" shadow />
                  </div>
              </b-card>
            </div>
          </div>
          <div class="section background background-no-bottom mb-0 pb-0">
            <div class="container">
              <div class="row">
                <div class="col-12 offset-0 col-lg-8 offset-lg-2 text-center">
                  <h1>감성 DJ를 즐기고 싶으시면?</h1>
                </div>
                <div class="col-12 offset-0 col-lg-6 offset-lg-3 newsletter-input-container">
                  <div class="text-center mb-3">
                    <a class="btn btn-secondary btn-xl" target="_blank" :href="adminRoot+'/main'">시작하기</a>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="section footer mb-0" id="sectionFooter">
            <div class="container">
              <div class="row footer-row">
                <div class="col-12 text-right">
                  <a
                    class="btn btn-circle btn-outline-semi-light footer-circle-button"
                    @click="scrollTo('#home')"
                    href="javascript:;"
                  >
                    <i class="simple-icon-arrow-up"></i>
                  </a>
                </div>
                <div class="col-12 text-center footer-content">

                </div>
              </div>
            </div>
            <div class="container copyright pt-5 pb-5">
              <div class="row">
                <div class="col-12"></div>
                <div class="col-12 text-center">
                  <p class="mb-0">2020 © 감성DJ by A505 | SSAFY</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </home-layout>
</template>

<script>
import { headroom } from "vue-headroom";
import VueScrollTo from "vue-scrollto";
import HomeLayout from "@/layouts/HomeLayout";
import GradientWithRadialProgressCard from "@/components/Cards/GradientWithRadialProgressCard"
import DoughnutChart from "@/components/Charts/Doughnut"
import LineChart from "@/components/Charts/Line"
import { ThemeColors } from '@/utils'
import { adminRoot } from "@/constants/config";
import http from '@/utils/http-common'
const colors = ThemeColors()
const doughnutData = [
  {
    labels: ["신나는 노래", "잔잔한 발라드", "기타"],
    datasets: [
        {
        label: '',
        borderColor: [colors.themeColor3, colors.themeColor2, colors.themeColor1],
        backgroundColor: [
            colors.themeColor3_10,
            colors.themeColor2_10,
            colors.themeColor1_10
        ],
        borderWidth: 2,
        data: [48, 18, 34]
        }
    ]
  },
  {
    labels: ["신나는 노래", "잔잔한 발라드", "사랑 노래"],
    datasets: [
        {
        label: '',
        borderColor: [colors.themeColor3, colors.themeColor2, colors.themeColor1, colors.themeColor4],
        backgroundColor: [
            colors.themeColor3_10,
            colors.themeColor2_10,
            colors.themeColor1_10,
            colors.themeColor4_10
        ],
        borderWidth: 2,
        data: [55, 24, 6]
        }
    ]
  },
  {
    labels: ["잔잔한 발라드", "사랑 노래", "신나는 노래"],
    datasets: [
        {
        label: '',
        borderColor: [colors.themeColor3, colors.themeColor2, colors.themeColor1, colors.themeColor4],
        backgroundColor: [
            colors.themeColor3_10,
            colors.themeColor2_10,
            colors.themeColor1_10,
            colors.themeColor4_10
        ],
        borderWidth: 2,
        data: [52, 18, 15]
        }
    ]
  },
]

const main = [
  {
    title: "즐거운 노래",
    img: "/assets/img/wordcloud/wc02.png",
    detail:
      "즐거운 감성과 관련된 단어들을 아시나요?<br/> 하늘, 태양, 빛나는 등 즐거운 노래에 자주 등장하는 가사들이 있답니다. <br/>우리는 이러한 가사들을 기반으로 즐거운 노래를 분석하여 제공합니다.<br/> 신나는 감성의 노래를 들어보세요~"
  },
  {
    title: "사랑 노래",
    img: "/assets/img/wordcloud/wc03.png",
    detail:
      "사랑이 시작되는 순간, 설레이는 감정을 느끼고 싶을 때, 어떤 노래를 들으시나요?<br/> 사랑, 그대, 눈빛, 입술.. 설레는 단어들로 사랑이라는 감성을 분석하였습니다.<br/> 설레는 순간에는 사랑노래를 들어보세요."
  },
  {
    title: "슬픈 노래",
    img: "/assets/img/wordcloud/wc01.png",
    detail:
      "사랑으로 슬플 때, 추억으로 슬플 때, 다양한 상황에서 슬픈 감성을 떠올리고 그 감성과 비슷한 노래를 찾아보신 적이 있었나요?<br/> 여기 당신만을 위한 슬픈 감성의 노래가 준비되어있습니다."
  }
];



const scrollOptions = {
  container: "body",
  easing: "ease-in",
  offset: -120,
  force: true,
  x: false,
  y: true
};

export default {
  components: {
    "gradient-with-radial-progress-card": GradientWithRadialProgressCard,
    "line-chart": LineChart,
    "home-layout": HomeLayout,
    DoughnutChart,
    headroom: headroom
  },
  data() {
    return {
      showMobileMenu: false,
      adminRoot,
      main,
      doughnutData,
      songWeather: [],
      songTime: [],
      favAmbiance:"가장 선호하는 감정의 음악은 joy 입니다.",
      favAmbianceProp:"63%",
      favArtist:"가장 많이 들은 가수는 방탄소년단 입니다.",
      favArtistProp:"45%",
      favGenre:"가장 좋아하는 장르는 랩/힙합 입니다.",
      favGenreProp:"26%",
      favTime:"18 시에서 ~ 20 시 사이에 가장 많이 들었습니다.",
      favTimeProp:"46%",
      lineChartData: {
        labels: ['00', '02', '04', '06', '08', '10', '12', '14', '16', '18', '20', '22'],
        datasets:
        [
            {
                label: '',
                data: [1, 1, 1, 2, 2, 8, 2, 4, 2, 11, 6, 0],
                borderColor: colors.themeColor1,
                pointBackgroundColor: colors.foregroundColor,
                pointBorderColor: colors.themeColor1,
                pointHoverBackgroundColor: colors.themeColor1,
                pointHoverBorderColor: colors.foregroundColor,
                pointRadius: 6,
                pointBorderWidth: 2,
                pointHoverRadius: 10,
                fill: false
            }
        ]
      },
    };
  },
  methods: {
    onWindowResize() {
      const homeRect = document
        .getElementById("homeRow")
        .getBoundingClientRect();
      const homeSection = document.getElementById("sectionHome");
      homeSection.style.backgroundPositionX = homeRect.x - 320 + "px";
      homeSection.style.width = window.innerWidth;
      const footerSection = document.getElementById("sectionFooter");
      footerSection.style.backgroundPositionX =
      event.target.innerWidth - homeRect.x - 2000 + "px";

      if (event.target.innerWidth >= 992) {
        this.showMobileMenu = false;
      }
    },
    onWindowScroll() {
      this.showMobileMenu = false;
    },
    onWindowClick() {
      this.showMobileMenu = false;
    },

    scrollTo(target) {
      VueScrollTo.scrollTo(target, 200, scrollOptions);
    },
    getWeather() {
      http.get('joy/')
      .then(res => {
        console.log(res.data)
        this.songWeather = res.data.slice(0, 6)
        console.log(this.songWeather)
      })
    },
    getTime() {
      http.get('recommend/time/')
      .then(res => {

        this.songTime = res.data.data.slice(0, 6)
      })
    }
  },
  mounted() {

    document.body.classList.add("no-footer");
    window.addEventListener("scroll", this.onWindowScroll);
    window.addEventListener("resize", this.onWindowResize);
    window.addEventListener("click", this.onWindowClick);
  },
  beforeDestroy() {
    document.body.classList.remove("no-footer");
    window.removeEventListener("scroll", this.onWindowScroll);
    window.removeEventListener("resize", this.onWindowResize);
    window.removeEventListener("click", this.onWindowClick);
  },
  created() {
    this.getWeather()
    this.getTime()
  }
};
</script>
<style scoped>
  video, .intro-carousel {
    width: 100%;
    height: auto;
    margin-top: 50px;
  }
</style>
