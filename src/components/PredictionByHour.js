export const js = ``
export const html = `
  <div class="pbhOuter">
    <div class="pbhStatus">
      <span>雨势减小</span>
    </div>
    <div class="pbhMain">
      <div class="pbhMainTop">
        <span>逐小时预报</span>
      </div>
      <div class="pbhContainer">
        <div class="pbhContent">
          <div class="pbhContentItem">
            <span>7:00</span>
            <span class="yb-big d00 pbhIcon"></span>
            <span class="pbhTemperature">-1°</span>
          </div>
          <div class="pbhContentItem">
            <span>7:00</span>
            <span class="yb-big d01 pbhIcon"></span>
            <span class="pbhTemperature">-1°</span>
          </div>
          <div class="pbhContentItem">
            <span>7:00</span>
            <span class="yb-big d02 pbhIcon"></span>
            <span class="pbhTemperature">-1°</span>
          </div>
          <div class="pbhContentItem">
            <span>7:00</span>
            <span class="yb-big d03 pbhIcon"></span>
            <span class="pbhTemperature">-1°</span>
          </div>
          <div class="pbhContentItem">
            <span>7:00</span>
            <span class="yb-big d04 pbhIcon"></span>
            <span class="pbhTemperature">-1°</span>
          </div>
          <div class="pbhContentItem">
            <span>7:00</span>
            <span class="yb-big d05 pbhIcon"></span>
            <span class="pbhTemperature">-1°</span>
          </div>
          <div class="pbhContentItem">
            <span>7:00</span>
            <span class="yb-big d06 pbhIcon"></span>
            <span class="pbhTemperature">-1°</span>
          </div>
          <div class="pbhContentItem">
            <span>7:00</span>
            <span class="yb-big d07 pbhIcon"></span>
            <span class="pbhTemperature">-1°</span>
          </div>
          <div class="pbhContentItem">
            <span>7:00</span>
            <span class="yb-big d08 pbhIcon"></span>
            <span class="pbhTemperature">-1°</span>
          </div>
          <div class="pbhContentItem">
            <span>7:00</span>
            <span class="yb-big n00 pbhIcon"></span>
            <span class="pbhTemperature">-1°</span>
          </div>
        </div>
      </div>
    </div>
  </div>
`
export const css = `
    .pbhOuter {
      color: #fff;
      font-size: 1rem;
    }

    .pbhMain {
      background: rgba(0, 0, 0, 0.2);
    }

    .pbhStatus {
      padding: 20px 20px 30px 20px;
      font-size: 1.3rem;
    }

    .pbhMainTop {
      padding: 20px;
      border-bottom: 1px solid #999;
      font-size: 1.3rem;
    }

    .pbhContent {
      display: flex;
      flex-direction: row;
      flex-wrap: nowrap;
      overflow-x: auto;
    }

    .pbhContentItem {
      display: flex;
      flex-direction: column;
      padding: 30px 20px;
    }

    .yb-big {
      margin: 30px 0;
    }
  `
