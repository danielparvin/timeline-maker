import React from "react";
import TimelineNotFound from '../timeline-not-found/TimelineNotFound';
import { useParams } from "react-router-dom";
import { RestClient } from "../../RestClient";
import './style/timeline.scss';

export async function loader({ params }: any) {
    return { params };
}

export default function Timeline() {
    let { id }: any = useParams();
    let [timeline, setTimeline] = React.useState<any>(undefined);
    React.useEffect(() => {
        RestClient.getTimeline(id)
            .then(timeline => setTimeline(timeline))
            .catch(err => alert(err)); /* TODO Handle  errors. */
    }, [id])

    if (timeline) {
        return (
            <>
                <h2>{timeline.name}</h2>
                <div className="timeline">
                    <div className="timeline__wrap">
                        <div className="timeline__items">
                            {timeline.events.map((e: any, i: number) =>
                                <div className={classNames('timeline__item', i % 2 ? 'timeline__item--left' : 'timeline__item--right')} key={e.id}>
                                    <div className="timeline__content">
                                        <h2>{e.name} | {e.date}</h2>
                                        <p>{e.description}</p>
                                    </div>
                                </div>
                            )}
                        </div>
                    </div>
                </div>
            </>
        )
    } else if (timeline === null) {
        return (
            <TimelineNotFound />
        );
    } else {
        return <p>Loading timeline...</p>
    }
}

function classNames(...args: any[]) {
    return args.filter(Boolean).join(' ');
}

const defaultSettings = {
    forceVerticalMode: {
      type: 'integer',
      defaultValue: 600
    },
    horizontalStartPosition: {
      type: 'string',
      acceptedValues: ['bottom', 'top'],
      defaultValue: 'top'
    },
    mode: {
      type: 'string',
      acceptedValues: ['horizontal', 'vertical'],
      defaultValue: 'vertical'
    },
    moveItems: {
      type: 'integer',
      defaultValue: 1
    },
    rtlMode: {
      type: 'boolean',
      acceptedValues: [true, false],
      defaultValue: false
    },
    startIndex: {
      type: 'integer',
      defaultValue: 0
    },
    verticalStartPosition: {
      type: 'string',
      acceptedValues: ['left', 'right'],
      defaultValue: 'left'
    },
    verticalTrigger: {
      type: 'string',
      defaultValue: '15%'
    },
    visibleItems: {
      type: 'integer',
      defaultValue: 3
    }
  };

  function isElementInViewport(el : any, triggerPosition : any) {
    const rect = el.getBoundingClientRect();
    const windowHeight = window.innerHeight || document.documentElement.clientHeight;
    const defaultTrigger = defaultSettings.verticalTrigger.defaultValue.match(/(\d*\.?\d*)(.*)/);
    let triggerUnit = triggerPosition.unit;
    let triggerValue = triggerPosition.value;
    let trigger = windowHeight;
    return (
      rect.top <= trigger
      && rect.left <= (window.innerWidth || document.documentElement.clientWidth)
      && (rect.top + rect.height) >= 0
      && (rect.left + rect.width) >= 0
    );
  }

  // Helper function to add transform styles
  function addTransforms(el: any, transform: any) {
    el.style.webkitTransform = transform;
    el.style.msTransform = transform;
    el.style.transform = transform;
  }
